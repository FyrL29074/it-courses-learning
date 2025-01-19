package com.fyrl29074.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "course")
data class CourseEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("summary")
    val summary: String,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("image_url")
    val imageUrl: String,
    @ColumnInfo("price")
    val price: Float,
    @ColumnInfo("display_price")
    val displayPrice: String,
    @ColumnInfo("create_date")
    val createDate: Date?,
    @ColumnInfo("course_url")
    val courseUrl: String,
)