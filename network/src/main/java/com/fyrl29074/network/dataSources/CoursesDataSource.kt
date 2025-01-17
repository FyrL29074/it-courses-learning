package com.fyrl29074.network.dataSources

import com.fyrl29074.network.api.CoursesApi
import com.fyrl29074.network.model.CourseDto

class CoursesDataSource(
    private val coursesApi: CoursesApi,
) {
    suspend fun getCourses(): List<CourseDto> {
        return coursesApi.getCourses().courses
    }
}