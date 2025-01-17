package com.fyrl29074.mainscreen.domain

interface CoursesRepository {

    suspend fun getCourses(): List<Course>
}