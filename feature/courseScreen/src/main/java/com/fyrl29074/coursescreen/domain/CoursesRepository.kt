package com.fyrl29074.coursescreen.domain

import com.fyrl29074.model.domain.Course
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {

    suspend fun addToFavourites(course: Course)

    suspend fun deleteFromFavourites(id: Int)
}