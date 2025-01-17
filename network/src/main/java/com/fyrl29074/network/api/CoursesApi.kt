package com.fyrl29074.network.api

import com.fyrl29074.network.model.CourseListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CoursesApi {

    @GET("courses")
    suspend fun getCourses(
        @Query("page") page: Int = 200,
    ): CourseListResponse
}