package com.example.traningtimer.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.traningtimer.database.TrainingEntity
import androidx.recyclerview.widget.ListAdapter
import com.example.traningtimer.databinding.ListItemBinding

class ListAdapter(private val inflater: LayoutInflater,
                  val onItemClick: (TrainingEntity) -> Unit
): ListAdapter<TrainingEntity, TrainingViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = TrainingViewHolder(
        ListItemBinding.inflate(inflater, parent, false),
        onItemClick)

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private object DiffCallback : DiffUtil.ItemCallback<TrainingEntity>() {
    override fun areItemsTheSame(oldItem: TrainingEntity, newItem: TrainingEntity) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TrainingEntity, newItem: TrainingEntity) =
        oldItem.date.timeInMillis == newItem.date.timeInMillis &&
                oldItem.type == newItem.type &&
                oldItem.weight == newItem.weight &&
                oldItem.count == newItem.count &&
                oldItem.isChecked == newItem.isChecked
}
