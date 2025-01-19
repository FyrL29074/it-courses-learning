package com.fyrl29074.favourites.domain

import com.fyrl29074.model.domain.Course
import kotlinx.coroutines.flow.Flow

class GetFavouritesCourseUseCase(
    private val favouritesRepository: FavouritesRepository,
) {
    fun execute(): Flow<List<Course>> {
        return favouritesRepository.getFavouritesCourse()
    }
}