package com.fyrl29074.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavourites(course: CourseEntity)

    @Query("SELECT * from course")
    fun getFavouritesCourse(): Flow<List<CourseEntity>>

    @Query("DELETE FROM course WHERE :id = id")
    suspend fun deleteFromFavourites(id: Int)
}