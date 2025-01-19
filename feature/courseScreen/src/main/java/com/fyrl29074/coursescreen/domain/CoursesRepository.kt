package com.fyrl29074.coursescreen.domain

import com.fyrl29074.model.domain.Course

interface CoursesRepository {

    suspend fun addToFavourites(course: Course)

    suspend fun deleteFromFavourites(id: Int)
}