package com.fyrl29074.mainscreen.data

import com.fyrl29074.local.LocalDataSource
import com.fyrl29074.mainscreen.domain.Course
import com.fyrl29074.mainscreen.domain.CoursesRepository
import com.fyrl29074.network.dataSources.NetworkDataSources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CoursesRepositoryImpl(
    private val networkDataSources: NetworkDataSources,
    private val networkCourseMapper: NetworkCourseMapper,
    private val localDataSource: LocalDataSource,
    private val localCourseMapper: LocalCourseMapper,
) : CoursesRepository {

    override suspend fun getCourses(): List<Course> {
        return networkDataSources.getCourses().map(networkCourseMapper::map)
    }

    override suspend fun addToFavourites(course: Course) {
        localDataSource.addToFavourites(localCourseMapper.map(course))
    }

    override fun getFavouritesCourse(): Flow<List<Course>> {
        return localDataSource.getFavouritesCourse().map { courses ->
            courses.map(localCourseMapper::map)
        }
    }

    override suspend fun deleteFromFavourites(id: Int) {
        localDataSource.deleteFromFavourites(id)
    }
}