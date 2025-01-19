package com.fyrl29074.coursescreen.domain

import com.fyrl29074.model.domain.Course

class AddToFavouritesUseCase(
    private val coursesRepository: CoursesRepository,
) {
    suspend fun execute(course: Course) {
        coursesRepository.addToFavourites(course)
    }
}