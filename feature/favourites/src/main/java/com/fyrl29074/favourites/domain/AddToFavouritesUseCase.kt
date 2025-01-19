package com.fyrl29074.favourites.domain

import com.fyrl29074.model.domain.Course

class AddToFavouritesUseCase(
    private val coursesRepository: FavouritesRepository,
) {
    suspend fun execute(course: Course) {
        coursesRepository.addToFavourites(course)
    }
}