package com.fyrl29074.mainscreen.domain

data class Course(
    val id: Int,
    val title: String,
    val summary: String,
    val description: String,
    val imageUrl: String,
    val displayPrice: String,
    val createData: String, // todo: maybe I should change to Date
    val updateData: String, // todo: maybe I should change to Date

    // TODO: I need to add review score here, but I didn't find it in API
//    val reviewScore: Float,
)