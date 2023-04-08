package com.example.traningtimer.ui.edit

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.traningtimer.database.TrainingEntity
import com.example.traningtimer.databinding.FragmentEditBinding
import com.google.android.material.datepicker.MaterialDatePicker
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

const val ITEM_KEY = "item_key"

class EditFragment: Fragment(), OnEditorActionListener {

    private lateinit var datePicker: MaterialDatePicker<Long>

    private var binding: FragmentEditBinding? = null

    private val editFragmentViewModel: EditFragmentViewModel by viewModel()

    private val listEditText = arrayListOf<EditText?>()

    private var trainingEntity: TrainingEntity? = null // Переменная для хранения выбранной модели

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // todo сохранение количество раз подходах

        // Кладём все editText в кучу, чтобы было легче к ним обращаться
        listEditText.apply {
            add(binding?.editText1)
            add(binding?.editText2)
            add(binding?.editText3)
            add(binding?.editText4)
            add(binding?.editText5)
            add(binding?.editText6)
            add(binding?.editText7)
            add(binding?.editText8)
            add(binding?.editText9)
            add(binding?.editText10)
        }
        // Назначаем editText слушатели
        listEditText.forEach {
            it?.setOnEditorActionListener(this)
        }

        // Получаем id переданный фрагментом списка
        val uuid = UUID.fromString(requireArguments().getString("itemKey"))
        // Передаем его viewModel для запроса в базу данных
        editFragmentViewModel.getItem(uuid)
        // Назначаем слушатель к запросу в базу данных
        editFragmentViewModel.itemLiveData.observe(viewLifecycleOwner) { item ->
            if (item == null) {
                // Если запрос не завершен не делаем ничего
            } else {
                // Если запрос завершен
                trainingEntity = item // Присваиваем модель полученную из базы данных локальной переменной
                // Заполняем editText значениями модели
                val data = item.count.split(";").toMutableList() // Делим строку на массив строк
                data.removeLast() // Удаляем последний элемент так как он пустой
                // Перебираем массив с подходами
                data.forEachIndexed { index, string ->
                    listEditText[index]?.setText(string) // И устанавливаем значения в подходе в editText
                }
                // Устанавливаем в кнопку дату выбранной тренировки
                binding?.buttonDate?.text = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(item.date.time)

                // Отображаем вес выбранной тренировки
                when(item.weight) {
                    0 -> { binding?.buttonWeight0?.isEnabled = false }
                    16 -> { binding?.buttonWeight16?.isEnabled = false }
                    24 -> { binding?.buttonWeight24?.isEnabled = false }
                    32 -> { binding?.buttonWeight32?.isEnabled = false }
                }
                // Отображаем тип выбранной тренировки
                when(item.type) {
                    1 -> { binding?.buttonType1?.isEnabled = false }
                    2 -> { binding?.buttonType2?.isEnabled = false }
                    3 -> { binding?.buttonType3?.isEnabled = false }
                    4 -> { binding?.buttonType4?.isEnabled = false }
                }
            }
        }

        initDatePicker()

        // Вызов datePicker
        binding?.buttonDate?.setOnClickListener {
            datePicker.show(parentFragmentManager, "tag")
        }
        // Выбор веса
        binding?.buttonWeight0?.setOnClickListener {
            trainingEntity?.weight = 0
            binding?.buttonWeight0?.isEnabled = false
            binding?.buttonWeight16?.isEnabled = true
            binding?.buttonWeight24?.isEnabled = true
            binding?.buttonWeight32?.isEnabled = true
        }
        binding?.buttonWeight16?.setOnClickListener {
            trainingEntity?.weight = 16
            binding?.buttonWeight16?.isEnabled = false
            binding?.buttonWeight0?.isEnabled = true
            binding?.buttonWeight24?.isEnabled = true
            binding?.buttonWeight32?.isEnabled = true
        }
        binding?.buttonWeight24?.setOnClickListener {
            trainingEntity?.weight = 24
            binding?.buttonWeight24?.isEnabled = false
            binding?.buttonWeight0?.isEnabled = true
            binding?.buttonWeight16?.isEnabled = true
            binding?.buttonWeight32?.isEnabled = true
        }
        binding?.buttonWeight32?.setOnClickListener {
            trainingEntity?.weight = 32
            binding?.buttonWeight32?.isEnabled = false
            binding?.buttonWeight0?.isEnabled = true
            binding?.buttonWeight16?.isEnabled = true
            binding?.buttonWeight24?.isEnabled = true
        }
        // Выбор типа
        binding?.buttonType1?.setOnClickListener {
            trainingEntity?.type = 1
            binding?.buttonType1?.isEnabled = false
            binding?.buttonType2?.isEnabled = true
            binding?.buttonType3?.isEnabled = true
            binding?.buttonType4?.isEnabled = true
        }
        binding?.buttonType2?.setOnClickListener {
            trainingEntity?.type = 2
            binding?.buttonType2?.isEnabled = false
            binding?.buttonType1?.isEnabled = true
            binding?.buttonType3?.isEnabled = true
            binding?.buttonType4?.isEnabled = true
        }
        binding?.buttonType3?.setOnClickListener {
            trainingEntity?.type = 3
            binding?.buttonType3?.isEnabled = false
            binding?.buttonType1?.isEnabled = true
            binding?.buttonType2?.isEnabled = true
            binding?.buttonType4?.isEnabled = true
        }
        binding?.buttonType4?.setOnClickListener {
            trainingEntity?.type = 4
            binding?.buttonType4?.isEnabled = false
            binding?.buttonType1?.isEnabled = true
            binding?.buttonType2?.isEnabled = true
            binding?.buttonType3?.isEnabled = true
        }
        // Блокирование (тренировка подтверждена)
        binding?.buttonCheck?.setOnClickListener {
            binding?.buttonCheck?.isEnabled = false
            trainingEntity?.isChecked = true
        }
        // Сохранение тренировки
        binding?.buttonSave?.setOnClickListener {
            // Формируем строку на основе данных из editText
            var newCount = ""
            listEditText.forEach {
                newCount += it?.text.toString() + ";"
            }
            trainingEntity?.count = newCount
            editFragmentViewModel.save(trainingEntity!!)
            findNavController().popBackStack()
        }
        // Удаление тренировки
        binding?.buttonDelete?.setOnClickListener {
            editFragmentViewModel.delete(trainingEntity!!)
            findNavController().popBackStack()
        }
    }

    private fun initDatePicker() {
        // Настраиваем datePicker
        datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Выберете дату")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
        // Назначаем слушатель
        datePicker.addOnPositiveButtonClickListener {
            val calendar = Calendar.getInstance() // Создаем объект типа Calendar
            calendar.timeInMillis = datePicker.selection!! // Задаем ему дату, выбранную в datePicker
            // Настраиваем дату для вывода куда-либо в формате 21.03.2019
            val date = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(calendar.time)
            binding?.buttonDate?.text = date
            trainingEntity?.date = calendar
        }
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        // При нажатии на кнопку "OK" виртуальной клавиатуры снимаем фокус с EditText
        v?.clearFocus()
        return false
    }
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}