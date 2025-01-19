package com.fyrl29074.mainscreen.di

import com.fyrl29074.coursescreen.di.CourseScreenModule
import com.fyrl29074.local.di.LocalModule
import com.fyrl29074.mainscreen.data.NetworkCourseMapper
import com.fyrl29074.mainscreen.data.CoursesRepositoryImpl
import com.fyrl29074.mainscreen.data.LocalCourseMapper
import com.fyrl29074.mainscreen.domain.CoursesRepository
import com.fyrl29074.mainscreen.domain.useCase.AddToFavouritesUseCase
import com.fyrl29074.mainscreen.domain.useCase.DeleteFromFavouritesUseCase
import com.fyrl29074.mainscreen.domain.useCase.GetCoursesFlowUseCase
import com.fyrl29074.mainscreen.presentation.CourseFormatter
import com.fyrl29074.mainscreen.presentation.mainScreen.MainViewModel
import com.fyrl29074.network.di.NetworkModule
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val MainFeatureModule = module {
    includes(NetworkModule, LocalModule, CourseScreenModule)

    singleOf(::CoursesRepositoryImpl) { bind<CoursesRepository>() }
    singleOf(::NetworkCourseMapper)
    singleOf(::LocalCourseMapper)

    singleOf(::GetCoursesFlowUseCase)
    singleOf(::AddToFavouritesUseCase)
    singleOf(::DeleteFromFavouritesUseCase)

    singleOf(::CourseFormatter)
    viewModel { MainViewModel(get(), get(), get(), get()) }
}