package com.fyrl29074.local.di

import com.fyrl29074.local.AppDatabase
import com.fyrl29074.local.LocalDataSource
import com.fyrl29074.local.provideDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val LocalModule = module {
    single { provideDatabase(androidContext()) }
    single { get<AppDatabase>().userDao() }
    singleOf(::LocalDataSource)
}