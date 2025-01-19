package com.fyrl29074.coursescreen.domain

class DeleteFromFavouritesUseCase(
    private val coursesRepository: CoursesRepository,
) {

    suspend fun execute(id: Int) {
        coursesRepository.deleteFromFavourites(id)
    }
}