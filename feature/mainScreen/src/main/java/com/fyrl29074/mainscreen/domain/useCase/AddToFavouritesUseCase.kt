package com.fyrl29074.mainscreen.domain.useCase

import com.fyrl29074.mainscreen.domain.CoursesRepository
import com.fyrl29074.model.domain.Course

class AddToFavouritesUseCase(
    private val coursesRepository: CoursesRepository,
) {
    suspend fun execute(course: Course) {
        coursesRepository.addToFavourites(course)
    }
}