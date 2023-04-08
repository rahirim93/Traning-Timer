package com.example.traningtimer.ui.list

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

    fun bind(model: TrainingEntity) {
        binding.apply {
            root.setOnClickListener { onItemClick(model) }
            Log.d("calendarCheck", formatDate(model))
            binding.textViewDate.text = formatDate(model)
            binding.textViewTypeWeight.text = formatTypeWeight(model)
            binding.textViewCount.text = formatCount(model)
            if (model.isChecked) {
                binding.isChecked.visibility = View.VISIBLE
            }


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
        formattedCount += " = $sum"
        return formattedCount
    }


}