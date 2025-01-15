package com.fyrl29074.network.model

import com.google.gson.annotations.SerializedName

data class CourseListResponse(
    @SerializedName("courses")
    val courses: List<CourseDto>
)