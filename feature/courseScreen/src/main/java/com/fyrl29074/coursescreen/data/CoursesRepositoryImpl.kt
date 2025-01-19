package com.fyrl29074.coursescreen.data

import com.fyrl29074.coursescreen.domain.CoursesRepository
import com.fyrl29074.local.LocalDataSource
import com.fyrl29074.model.domain.Course

class CoursesRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val localCourseMapper: LocalCourseMapper,
) : CoursesRepository {

    override suspend fun addToFavourites(course: Course) {
        localDataSource.addToFavourites(localCourseMapper.map(course))
    }

    override suspend fun deleteFromFavourites(id: Int) {
        localDataSource.deleteFromFavourites(id)
    }
}