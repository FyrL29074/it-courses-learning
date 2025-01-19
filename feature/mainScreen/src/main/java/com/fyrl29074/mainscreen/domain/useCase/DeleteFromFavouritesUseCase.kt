package com.fyrl29074.mainscreen.domain.useCase

import com.fyrl29074.mainscreen.domain.CoursesRepository

class DeleteFromFavouritesUseCase(
    private val coursesRepository: CoursesRepository,
) {

    suspend fun execute(id: Int) {
        coursesRepository.deleteFromFavourites(id)
    }
}