package ru.iddqdpwn.vkonkurse.core.domain

data class Giveaway(
    val title: String,
    val link: String,
    val date: Long,
    val id: Long?
)