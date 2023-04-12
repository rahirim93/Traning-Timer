package com.example.traningtimer.ui.save

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.traningtimer.database.TrainingEntity
import com.example.traningtimer.databinding.FragmentSaveBinding
import com.example.traningtimer.ui.settings.SettingsFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class SaveFragment: Fragment() {

    private val saveViewModel: SaveFragmentViewModel by viewModel()

    private var binding: FragmentSaveBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSaveBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Выводим дату тренировки
        binding?.textView4?.append("Дата: ${SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(saveViewModel.getDate().time)}")

        // Выводим количество раз в подходах
        // Получаем массив id кнопок, которые являются ключами для SharedPreferences
        requireArguments().getIntArray("intArray")?.forEachIndexed { index,it->
            // Если цвет зеленый, что значит что подход выполнен выводим в textView его значение из SharedPreferences, т.е. количество раз
            if (saveViewModel.getColor(it, Color.BLACK) == Color.GREEN) {
                binding?.textView4?.append("\nПодход: ${index+1}.\tКол-во: ${saveViewModel.getText(it, "0")}")
            } else {
                // Если не зеленый, что значит что подход не выполнен, то выводим его значение из SharedPreferences по умолчанию, т.е. 0
                binding?.textView4?.append("\nПодход: ${index+1}.\tКол-во: ${saveViewModel.getText(it, "0")}")
            }
        }

        // Выводим тип тренировки
        when(saveViewModel.getType()) {
            1 -> { binding?.textView4?.append("\nТип: подтягивания пр.") }
            2 -> { binding?.textView4?.append("\nТип: подтягивания обр.") }
            3 -> { binding?.textView4?.append("\nТип: отжимания на брусьях.") }
            4 -> { binding?.textView4?.append("\nТип: выходы.") }
        }

        // Выводим вес тренировки
        binding?.textView4?.append("\nВес: ${saveViewModel.getWeight()}")

        binding?.buttonAdd?.setOnClickListener {
            // Формируем строку с количеством раз
            var stringForDB = ""
            requireArguments().getIntArray("intArray")?.forEach {
                stringForDB += "${saveViewModel.getText(it, "0")};"
            }
            saveViewModel
                .addItem(
                    TrainingEntity(
                        date = saveViewModel.getDate(),
                        count = stringForDB,
                        weight = saveViewModel.getWeight(),
                        type = saveViewModel.getType()))

        }

        if (saveViewModel.getBlocked()) {
            binding?.buttonUnblock?.text = "Разблокировать"
        } else {
            binding?.buttonUnblock?.text = "Заблокировать"
        }
        binding?.buttonUnblock?.setOnClickListener {
            saveViewModel.changeBlocked()
            if (saveViewModel.getBlocked()) {
                binding?.buttonUnblock?.text = "Разблокировать"
            } else {
                binding?.buttonUnblock?.text = "Заблокировать"
            }
        }

        binding?.buttonList?.setOnClickListener {
            findNavController().navigate(SaveFragmentDirections.toListFragment())
        }


    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}