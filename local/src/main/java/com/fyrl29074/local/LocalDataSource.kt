package com.fyrl29074.local

import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val courseDao: CourseDao,
) {
    suspend fun addToFavourites(course: CourseEntity) {
        courseDao.addToFavourites(course)
    }

    fun getFavouritesCourse(): Flow<List<CourseEntity>> {
        return courseDao.getFavouritesCourse()
    }

    suspend fun deleteFromFavourites(id: Int) {
        courseDao.deleteFromFavourites(id)
    }
}