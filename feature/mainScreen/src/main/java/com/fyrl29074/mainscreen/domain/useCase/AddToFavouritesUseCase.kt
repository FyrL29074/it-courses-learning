package com.fyrl29074.mainscreen.domain.useCase

import com.fyrl29074.mainscreen.domain.Course
import com.fyrl29074.mainscreen.domain.CoursesRepository

class AddToFavouritesUseCase(
    private val coursesRepository: CoursesRepository,
) {
    suspend fun execute(course: Course) {
        coursesRepository.addToFavourites(course)
    }
}