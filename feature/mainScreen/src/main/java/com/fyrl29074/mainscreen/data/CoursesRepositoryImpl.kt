package com.fyrl29074.mainscreen.data

import com.fyrl29074.mainscreen.domain.Course
import com.fyrl29074.mainscreen.domain.CoursesRepository
import com.fyrl29074.network.dataSources.CoursesDataSource

class CoursesRepositoryImpl(
    private val coursesDataSource: CoursesDataSource,
    private val courseMapper: CourseMapper,
) : CoursesRepository {
    override suspend fun getCourses(): List<Course> {
        return coursesDataSource.getCourses().map(courseMapper::map)
    }
}