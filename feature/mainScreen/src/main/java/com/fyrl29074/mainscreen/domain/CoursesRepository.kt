package com.fyrl29074.mainscreen.domain

import com.fyrl29074.model.domain.Course
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {

    suspend fun getCourses(): List<Course>

    suspend fun addToFavourites(course: Course)

    fun getFavouritesCourse(): Flow<List<Course>>

    suspend fun deleteFromFavourites(id: Int)
}