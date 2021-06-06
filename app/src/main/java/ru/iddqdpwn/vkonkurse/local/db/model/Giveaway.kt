package ru.iddqdpwn.vkonkurse.local.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Giveaway(
    val title: String,
    val link: String,
    val date: Long,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
)