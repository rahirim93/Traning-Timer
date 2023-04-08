package com.example.traningtimer.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.traningtimer.R
import com.example.traningtimer.databinding.ActivityMainBinding
import com.example.traningtimer.ui.second.SecondFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(), View.OnClickListener {

    /**
     * Подумать о хранении в следующем виде:
     * вся информация о тренировке будет хранится не в тексте кнопок,
     * а в репозитории. И в зависимости от состояния репозитория будут изменяться состояния кнопок.
     *
     * Нажатие кнопки будем не обрабатывать сдесь, а нажатием будем менять состояние репозитория
     * а при возвращении будем перерисовывать вид исходя из изменений репозитория
     */

    private val mainViewModel: MainViewModelFrag by viewModel()

    private var binding: ActivityMainBinding? = null

    private val listTrainingButtons = arrayListOf<Button>()
    private val listChoiceWeightTypeTimeButtons = arrayListOf<Button>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ActivityMainBinding.inflate(inflater, container, false)
        return binding!!.root
    }


    /**
     * При входе:
     * если тренировка не сброшена, то продолжить
     * если сброшена, то выбрать тренировку вес и тп
     * в репозитории []ранить состояние тренировки вес и тп, так пусковой фрагмент будет понимать запускать ся или нет
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        // Работа с кнопками настроек
        listChoiceWeightTypeTimeButtons.apply {
            // Не работаем с этими кнопками.
            // Если в дальнейшем не пригодятся - убрать.
            //clear()
            //add(binding!!.buttonWeight16)
            //add(binding!!.buttonWeight)
        }


        binding?.buttonReport?.setOnClickListener {
            val intArrayList = arrayListOf<Int>()
            listTrainingButtons.forEach {
                intArrayList.add(it.id)
            }
            findNavController().navigate(R.id.toSaveFragment, bundleOf("intArray" to intArrayList.toIntArray()))
        }

        binding?.buttonReset?.setOnClickListener {
            // todo Написать сброс подходов.
            mainViewModel.setStarted(false)
            // При сбросе перейти на фрагмент настройки тренировки.
            mainViewModel.clearSharPref()
            findNavController().popBackStack()
        }

        // todo Написать сохранение состояния тренировки.

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

    override fun onClick(v: View) {

        findNavController().navigate(R.id.toSecondFragment, bundleOf(SecondFragment.BUTTON_ID to v.id))
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}