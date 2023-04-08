package com.example.traningtimer.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


// Count - строка содержащая количество подходов и количество раз в подходах с разделителями.
// Пока сделать только так. В дальнейшем нужно будет в эту строку добавить также время между подходами.
// Так как строки с подходами будут уже сформированы и в старые время добавить будет невозможно,
// то нужно будет добавлять отдельное поле, а не вставлять время в это.
// Например, 1.10;2.12 значит 2 подхода 10 раз в первом и 12 во втором.

// Weight - вес отягощения в тренировке.

// Type - тип тренировки. На текущий момент типа 4:
//      1 - подтягивания;
//      2 - подтягивания обратным хватом;
//      3 - отжимания на брусьях;
//      4 - выходы силой.

@Entity(tableName = "training_table")
data class TrainingEntity(
    @PrimaryKey var id: UUID = UUID.randomUUID(),
    var date: Calendar,
    var count: String,
    var weight: Int,
    var type: Int,
    var isChecked: Boolean = false)