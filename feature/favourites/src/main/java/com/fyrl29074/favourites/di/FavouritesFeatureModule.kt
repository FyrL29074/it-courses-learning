package com.fyrl29074.favourites.di

import com.fyrl29074.coursescreen.di.CourseScreenModule
import com.fyrl29074.favourites.data.FavouritesRepositoryImpl
import com.fyrl29074.favourites.data.LocalCourseMapper
import com.fyrl29074.favourites.domain.AddToFavouritesUseCase
import com.fyrl29074.favourites.domain.DeleteFromFavouritesUseCase
import com.fyrl29074.favourites.domain.FavouritesRepository
import com.fyrl29074.favourites.domain.GetFavouritesCourseUseCase
import com.fyrl29074.favourites.presentation.CourseFormatter
import com.fyrl29074.favourites.presentation.FavouritesViewModel
import com.fyrl29074.local.di.LocalModule
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val FavouritesFeatureModule = module {
    includes(LocalModule, CourseScreenModule)

    singleOf(::FavouritesRepositoryImpl) { bind<FavouritesRepository>() }
    singleOf(::LocalCourseMapper)

    singleOf(::AddToFavouritesUseCase)
    singleOf(::DeleteFromFavouritesUseCase)
    singleOf(::GetFavouritesCourseUseCase)

    singleOf(::CourseFormatter)
    viewModelOf(::FavouritesViewModel)
}