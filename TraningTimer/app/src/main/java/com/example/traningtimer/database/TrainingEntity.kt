package com.example.traningtimer.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


// count - строка содержащая количество подходов и количество раз в подходах с разделителями.
// пока сделать только так. в дальнейшем нужно будет в эту строку добавить также время между подходами.
// так как строки с подходами будут уже сформированы и в старые время добавить будет невозможно,
// то нужно будет добавлять отдельное поле, а не в вставлять время в это.
// Например, 1.10;2.12 значит 2 подхода 10 раз в первом и 12 во втором.

// weight - вес отягощения в тренировке.

// type - тип тренировки. на текущий момент типа 3:
//      1 - подтягивания;
//      2 - отжимания на брусьях;
//      3 - выходы силой.
// в дальнейшем нужно подумать о различии в хватах подтягиваниях, пока оставим без различий.

/**
 * Забыл добавить дату тренировки
 */

@Entity(tableName = "training_table")
data class TrainingEntity(
    @PrimaryKey var id: UUID = UUID.randomUUID(),
    var date: Calendar,
    var count: String,
    var weight: Int,
    var type: Int)