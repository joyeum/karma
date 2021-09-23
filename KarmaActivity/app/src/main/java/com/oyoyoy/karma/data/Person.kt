package com.oyoyoy.karma.data

import androidx.annotation.DrawableRes

data class Person(
    val id: Long,
    val name: String,
    @DrawableRes
    val image: Int?,
    val description: String
)
