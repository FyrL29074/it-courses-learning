package com.fyrl29074.network.di

import com.fyrl29074.network.api.CoursesApi
import com.fyrl29074.network.api.ServerInfo
import com.fyrl29074.network.dataSources.NetworkDataSources
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module {

    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(ServerInfo.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoursesApi::class.java)
    }

    singleOf(::NetworkDataSources)
}