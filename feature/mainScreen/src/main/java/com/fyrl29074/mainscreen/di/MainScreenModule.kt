package com.fyrl29074.mainscreen.di

import com.fyrl29074.mainscreen.data.CourseMapper
import com.fyrl29074.mainscreen.data.CoursesRepositoryImpl
import com.fyrl29074.mainscreen.domain.CoursesRepository
import com.fyrl29074.mainscreen.domain.GetCoursesUseCase
import com.fyrl29074.mainscreen.presentation.CourseFormatter
import com.fyrl29074.mainscreen.presentation.MainViewModel
import com.fyrl29074.network.di.NetworkModule
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val MainFeatureModule = module {
    includes(NetworkModule)

    singleOf(::CoursesRepositoryImpl) { bind<CoursesRepository>() }
    singleOf(::CourseMapper)

    singleOf(::GetCoursesUseCase)

    singleOf(::CourseFormatter)
    viewModel { MainViewModel(get(), get()) }
}