package com.fyrl29074.mainscreen.domain

import java.util.Date

data class Course(
    val id: Int,
    val title: String,
    val summary: String,
    val description: String,
    val imageUrl: String,
    val price: Float,
    val displayPrice: String,
    val createDate: Date?,
    val courseUrl: String,
    val isFavourite: Boolean,

    // TODO: I need to add review score here, but I didn't find it in API
//    val reviewScore: Float,
)