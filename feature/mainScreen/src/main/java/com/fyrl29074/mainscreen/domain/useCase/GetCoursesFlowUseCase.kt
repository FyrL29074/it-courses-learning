package com.fyrl29074.mainscreen.domain.useCase

import com.fyrl29074.mainscreen.domain.CoursesRepository
import com.fyrl29074.model.domain.Course
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf

class GetCoursesFlowUseCase(
    private val coursesRepository: CoursesRepository,
) {
    suspend fun execute(): Flow<List<Course>> {
        // it's for pagination in future
        val networkFlowList = flowOf(coursesRepository.getCourses())
        val localFlowList = coursesRepository.getFavouritesCourse()

        return combine(networkFlowList, localFlowList) { networkCourses, favouritesCourses ->
            val favouritesCoursesId = favouritesCourses.map { it.id }.toSet()
            networkCourses.map { course ->
                if (course.id in favouritesCoursesId) {
                    course.copy(isFavourite = true)
                } else {
                    course
                }
            }
        }
    }
}