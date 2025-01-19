package com.fyrl29074.network.dataSources

import com.fyrl29074.network.api.CoursesApi
import com.fyrl29074.network.model.CourseDto

class NetworkDataSources(
    private val coursesApi: CoursesApi,
) {
    suspend fun getCourses(): List<CourseDto> {

        // TODO: it's better to catch only network exception and handle it to show toast
        // TODO: also it's better to retry request
        return try {
            coursesApi.getCourses().courses
        } catch (e: Exception) {
            emptyList()
        }
    }
}