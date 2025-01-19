package com.fyrl29074.mainscreen.domain

import kotlinx.coroutines.flow.Flow

interface CoursesRepository {

    suspend fun getCourses(): List<Course>

    suspend fun addToFavourites(course: Course)

    fun getFavouritesCourse(): Flow<List<Course>>

    suspend fun deleteFromFavourites(id: Int)
}