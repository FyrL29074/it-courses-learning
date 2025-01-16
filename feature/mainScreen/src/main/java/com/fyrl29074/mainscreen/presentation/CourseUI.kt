package com.fyrl29074.mainscreen.presentation

import java.util.Date

data class CourseUI(
    val id: Int,
    val title: String,
    val summary: String,
    val description: String,
    val imageUrl: String,
    val price: Float,
    val displayPrice: String,
    val dayOfMonth: String?,
    val monthName: String?,
    val year: String?,
    val createDate: Date?, // for sorting

    // TODO: I need to add review score here, but I didn't find it in API
//    val reviewScore: Float,

)
