package com.fyrl29074.favourites.data

import com.fyrl29074.favourites.domain.FavouritesRepository
import com.fyrl29074.local.LocalDataSource
import com.fyrl29074.model.domain.Course
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavouritesRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val localCourseMapper: LocalCourseMapper,
) : FavouritesRepository {

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