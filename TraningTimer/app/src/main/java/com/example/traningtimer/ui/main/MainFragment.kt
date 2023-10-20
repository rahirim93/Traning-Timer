package com.example.traningtimer.ui.main

import android.app.AlarmManager
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.audiofx.Equalizer.Settings
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.traningtimer.R
import com.example.traningtimer.SHARED_PREFERENCES_NAME1
import com.example.traningtimer.TrainingRepository
import com.example.traningtimer.databinding.ActivityMainBinding
import com.example.traningtimer.traningService.Actions
import com.example.traningtimer.traningService.EndlessService
import com.example.traningtimer.traningService.ServiceState
import com.example.traningtimer.traningService.getServiceState
import com.example.traningtimer.traningService.log
import com.example.traningtimer.ui.second.SecondFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

const val SHARED_TRAINING_TIME = "training time"
class MainFragment : Fragment(), View.OnClickListener {
    /**
     * Подумать о хранении в следующем виде:
     * вся информация о тренировке будет храниться не в тексте кнопок,
     * а в репозитории. И в зависимости от состояния репозитория будут изменяться состояния кнопок.
     *
     * Нажатие кнопки будем не обрабатывать здесь, а нажатием будем менять состояние репозитория,
     * а при возвращении будем перерисовывать вид исходя из изменений репозитория
     */

    private val mainViewModel: MainViewModelFrag by viewModel()

    private var binding: ActivityMainBinding? = null

    private val listTrainingButtons = arrayListOf<Button>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ActivityMainBinding.inflate(inflater, container, false)
        Log.d("lifecycle", "onCreateView")
        return binding!!.root
    }


    /**
     * При входе:
     * если тренировка не сброшена, то продолжить
     * если сброшена, то выбрать тренировку вес и тп
     * в репозитории []ранить состояние тренировки вес и тп, так пусковой фрагмент будет понимать запускать ся или нет
     */

    // todo сделать время таймера тренировок
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("lifecycle", "onViewCreated")

        initButtons()

        listTrainingButtons.forEach {
            it.textSize = 10.0F
        }

        setThings()

        // Включаем режим звонка
        setRingerMode(AudioManager.RINGER_MODE_NORMAL)

        actionOnService(Actions.START)



        mainViewModel.getLastTraining().observe(viewLifecycleOwner) {item ->
            if (item != null) {
                val data = item.count.split(";").toMutableList() // Делим строку на массив строк
                data.removeLast() // Удаляем последний элемент так как он пустой
                var string = ""
                data.forEachIndexed { index, s ->
                    string += s
                    if (index == data.lastIndex) return@forEachIndexed
                    string += " + "
                }
                binding?.textViewLastTraining?.text = string
            }

        }

    }

    override fun onClick(v: View) {
        findNavController().navigate(R.id.toSecondFragment, bundleOf(SecondFragment.BUTTON_ID to v.id))
    }
    private fun initButtons() {
        // Работа с кнопками подходов
        listTrainingButtons.clear()
        listTrainingButtons.apply {
            add(binding!!.button1)
            add(binding!!.button2)
            add(binding!!.button3)
            add(binding!!.button4)
            add(binding!!.button5)
            add(binding!!.button6)
            add(binding!!.button7)
            add(binding!!.button8)
            add(binding!!.button9)
            add(binding!!.button10)
            forEach {
                // Восстановления состояния кнопок из репозитория
                it.text = mainViewModel.getText(it.id, it.text.toString())
                it.setTextColor(mainViewModel.getColor(it.id, it.currentTextColor))
                it.isEnabled = mainViewModel.getEnabled(it.id, it.isEnabled)
                it.visibility = mainViewModel.getVisibility(it.id, it.visibility)
                // Назначения слушателя
                it.setOnClickListener(this@MainFragment)
            }
        }

        binding?.buttonReport?.setOnClickListener {
            val intArrayList = arrayListOf<Int>()
            listTrainingButtons.forEach {
                intArrayList.add(it.id)
            }
            actionOnService(Actions.STOP)
            findNavController().navigate(R.id.toSaveFragment, bundleOf("intArray" to intArrayList.toIntArray()))
        }

        binding?.buttonReset?.setOnClickListener {
            // todo Написать сброс подходов.
            mainViewModel.setStarted(false)
            // При сбросе перейти на фрагмент настройки тренировки.
            mainViewModel.clearSharPref()
            // Меняем режим звонка на беззвучный
            setRingerMode(AudioManager.RINGER_MODE_SILENT)
            actionOnService(Actions.STOP)
            findNavController().popBackStack()
        }

        // Отображение текущего времени отдыха
        val sharedPreferences = requireContext().getSharedPreferences(SHARED_PREFERENCES_NAME1, Context.MODE_PRIVATE)
        when(sharedPreferences.getInt(SHARED_TRAINING_TIME, 180)) {
            120 -> { binding?.buttonTimeRelax?.text = "2" }
            180 -> { binding?.buttonTimeRelax?.text = "3" }
            240 -> { binding?.buttonTimeRelax?.text = "4" }
        }
        // Изменение времени отдыха
        binding?.buttonTimeRelax?.setOnClickListener {
            log("${sharedPreferences.getInt(SHARED_TRAINING_TIME,0)}")

            when(sharedPreferences.getInt(SHARED_TRAINING_TIME, 180)) {
                120 -> {
                    sharedPreferences.edit().apply {
                        putInt(SHARED_TRAINING_TIME, 180)
                        apply()
                    }
                    binding?.buttonTimeRelax?.text = "3"
                }
                180 -> {
                    sharedPreferences.edit().apply {
                        putInt(SHARED_TRAINING_TIME, 240)
                        apply()
                    }
                    binding?.buttonTimeRelax?.text = "4"
                }
                240 -> {
                    sharedPreferences.edit().apply {
                        putInt(SHARED_TRAINING_TIME, 120)
                        apply()
                    }
                    binding?.buttonTimeRelax?.text = "2"
                }
            }
        }
        // Отменить таймер
        binding?.buttonStopAlarm?.setOnClickListener {
            actionOnService(Actions.STOP_ALARM)
        }
    }
    private fun setThings() {
        parentFragmentManager.setFragmentResultListener(SecondFragment.REQUEST_CODE, viewLifecycleOwner) {_, data ->
            // Обработка данных полученных со второго фрагмента
        }

        // Выход из приложения при смахивании вправо.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        })
    }
    private fun setRingerMode(ringerMode: Int) {
        val notificationManager = requireActivity()
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (!notificationManager.isNotificationPolicyAccessGranted) {
            val intent = Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
            startActivity(intent)
        }
        val alarmManager = requireActivity().getSystemService(Context.AUDIO_SERVICE) as AudioManager
        alarmManager.ringerMode = ringerMode
    }
    private fun actionOnService(action: Actions) {
        if (getServiceState(requireContext()) == ServiceState.STOPPED && action == Actions.STOP) return
        Intent(requireContext(), EndlessService::class.java).also {
            it.action = action.name
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //log("Starting the service in >=26 Mode")
                requireContext().startForegroundService(it)
                return
            }
            //log("Starting the service in < 26 Mode")
            requireContext().startService(it)
        }
    }
    override fun onDestroyView() {
        Log.d("lifecycle", "onDestroyView")
        binding = null
        super.onDestroyView()
    }
}