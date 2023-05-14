package com.example.traningtimer.ui.list

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.traningtimer.database.TrainingEntity
import com.example.traningtimer.databinding.ListItemBinding
import java.text.SimpleDateFormat
import java.util.*

class TrainingViewHolder(
    private val binding: ListItemBinding,
    val onItemClick: (TrainingEntity) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: TrainingEntity, nextModel: TrainingEntity) {
        binding.apply {
            root.setOnClickListener { onItemClick(model) }
            Log.d("calendarCheck", "check" )
            binding.textViewDate.text = formatDate(model)
            binding.textViewTypeWeight.text = formatTypeWeight(model)
            //binding.textViewCount.text = formatCount(model)
            //binding.textViewCount.text = formatCount2(model, nextModel)
            //binding.textViewCount.textSize = 10.0F
            if (model.isChecked) {
                binding.isChecked.visibility = View.VISIBLE
            }

            val listTextView = arrayListOf<TextView>()
            listTextView.add(binding.textViewCount1)
            listTextView.add(binding.textViewCount2)
            listTextView.add(binding.textViewCount3)
            listTextView.add(binding.textViewCount4)
            listTextView.add(binding.textViewCount5)
            listTextView.add(binding.textViewCount6)
            listTextView.add(binding.textViewCount7)
            listTextView.add(binding.textViewCount8)
            listTextView.add(binding.textViewCount9)
            listTextView.add(binding.textViewCount10)

            val dataModel = model.count.split(";").toMutableList() // Разбиваем строку первой модели
            val dataNextModel = nextModel.count.split(";").toMutableList() // Разбиваем строку второй модели
            dataModel.removeAt(dataModel.size - 1) // Убираем пустую ячейку
            dataNextModel.removeAt(dataNextModel.size - 1) // Убираем пустую ячейку
            var summ = 0
            dataModel.forEachIndexed { index, s ->
                summ += s.toInt()
                listTextView[index].text = s
                if (dataModel[index] > dataNextModel[index]) listTextView[index].setTextColor(Color.GREEN)
                if (dataModel[index] < dataNextModel[index]) listTextView[index].setTextColor(Color.RED)
                if (dataModel[index] == dataNextModel[index]) listTextView[index].setTextColor(Color.YELLOW)
            }
            binding.textViewSum.text = "$summ"

            //isCompleted.isChecked = model.isCompleted
            //desc.text = model.description

        }
    }

    private fun formatDate(model: TrainingEntity): String {
        var date = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            .format(model.date.time)
        when(model.date.get(Calendar.DAY_OF_WEEK)) {
            1 -> { date += ", Воскресенье" }
            2 -> { date += ", Понедельник" }
            3 -> { date += ", Вторник" }
            4 -> { date += ", Среда" }
            5 -> { date += ", Четверг" }
            6 -> { date += ", Пятница" }
            7 -> { date += ", Суббота" }
        }
        return date
    }

    private fun formatTypeWeight(model: TrainingEntity): String {
        var typeWeight = ""
        when(model.type) {
            1 -> { typeWeight += "Подтягивания пр." }
            2 -> { typeWeight += "Подтягивания обр." }
            3 -> { typeWeight += "Отжимания на брусьях" }
            4 -> { typeWeight += "Выходы силой" }
        }
        typeWeight += ", ${model.weight} кг"
        return  typeWeight
    }

    // Старая функция.
    private fun formatCount(model: TrainingEntity): String {
        val data = model.count.split(";").toMutableList()
        data.removeAt(data.size - 1) // Убираем пустую ячейку
        var formattedCount = ""
        var sum = 0
        data.forEachIndexed { index, s ->
            sum += s.toInt()
            if (index < data.size - 1) formattedCount += "$s + "
            if (index == data.size -1) formattedCount += s
        }
        formattedCount += " = $sum \u2191"
        return formattedCount
    }

    // Форматирование для двух моделей (старая функция).
    private fun formatCount2(model: TrainingEntity, nextModel: TrainingEntity): String {
        val data1 = model.count.split(";").toMutableList() // Разбиваем строку первой модели
        val data2 = nextModel.count.split(";").toMutableList() // Разбиваем строку второй модели
        data1.removeAt(data1.size - 1) // Убираем пустую ячейку
        data2.removeAt(data2.size - 1) // Убираем пустую ячейку
        var formattedCount = ""
        var sum = 0
        data1.forEachIndexed { index, s ->
            sum += s.toInt()
            if (index < data1.size - 1) {
                if (data1[index].toInt() > data2[index].toInt()) formattedCount += "$s\u2191 + "
                if (data1[index].toInt() < data2[index].toInt()) formattedCount += "$s\u2193 + "
                if (data1[index].toInt() == data2[index].toInt()) formattedCount += "$s + "
            }

            if (index == data1.size - 1) {
                if (data1[index].toInt() > data2[index].toInt()) formattedCount += "$s\u2191"
                if (data1[index].toInt() < data2[index].toInt()) formattedCount += "$s\u2193"
                if (data1[index].toInt() == data2[index].toInt()) formattedCount += s
            }
        }
        formattedCount += " = $sum"
        return formattedCount
    }

}