package com.fyrl29074.mainscreen.domain

class GetCoursesUseCase(
    private val repository: CoursesRepository,
) {
    suspend fun execute(): List<Course> {
        return repository.getCourses()
    }
}