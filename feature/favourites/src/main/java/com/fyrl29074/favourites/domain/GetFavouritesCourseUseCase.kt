package com.fyrl29074.favourites.domain

import com.fyrl29074.mainscreen.domain.Course
import com.fyrl29074.mainscreen.domain.CoursesRepository
import kotlinx.coroutines.flow.Flow

class GetFavouritesCourseUseCase(
    private val coursesRepository: CoursesRepository,
) {
    fun execute(): Flow<List<Course>> {
        return coursesRepository.getFavouritesCourse()
    }
}