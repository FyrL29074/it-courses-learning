package com.fyrl29074.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fyrl29074.local.converters.DateConverter

@Database(entities = [CourseEntity::class], version = 1, exportSchema = true)
@TypeConverters(DateConverter::class)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): CourseDao
}

internal fun provideDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app_database"
    ).build()
}