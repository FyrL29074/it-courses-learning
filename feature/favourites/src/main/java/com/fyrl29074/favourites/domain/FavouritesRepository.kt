package com.fyrl29074.favourites.domain

import com.fyrl29074.model.domain.Course
import kotlinx.coroutines.flow.Flow

interface FavouritesRepository {

    suspend fun addToFavourites(course: Course)

    fun getFavouritesCourse(): Flow<List<Course>>

    suspend fun deleteFromFavourites(id: Int)
}