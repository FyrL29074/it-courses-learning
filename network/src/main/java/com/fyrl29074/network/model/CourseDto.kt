package com.fyrl29074.network.model

import com.google.gson.annotations.SerializedName

data class CourseDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("summary")
    val summary: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("cover")
    val imageUrl: String,

    @SerializedName("display_price")
    val displayPrice: String,

    @SerializedName("create_date")
    val createData: String, // todo: maybe I should change to Date

    @SerializedName("update_date")
    val updateData: String, // todo: maybe I should change to Date

    // TODO: I need to add review score here, but I didn't find it in API
//    @SerializedName("")
//    val reviewScore: Float,
)
