package com.fyrl29074.coursescreen.di

import com.fyrl29074.coursescreen.data.CoursesRepositoryImpl
import com.fyrl29074.coursescreen.data.LocalCourseMapper
import com.fyrl29074.coursescreen.domain.AddToFavouritesUseCase
import com.fyrl29074.coursescreen.domain.CoursesRepository
import com.fyrl29074.coursescreen.domain.DeleteFromFavouritesUseCase
import com.fyrl29074.coursescreen.presentation.CourseFormatter
import com.fyrl29074.coursescreen.presentation.CourseViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val CourseScreenModule = module {
    singleOf(::CoursesRepositoryImpl) { bind<CoursesRepository>() }
    singleOf(::LocalCourseMapper)

    singleOf(::AddToFavouritesUseCase)
    singleOf(::DeleteFromFavouritesUseCase)

    singleOf(::CourseFormatter)
    viewModelOf(::CourseViewModel)
}