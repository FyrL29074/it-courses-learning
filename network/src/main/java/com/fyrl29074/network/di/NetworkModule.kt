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

val NetworkModule = module {

    single {
        // TODO: handle java.net.SocketTimeoutException: timeout
        // TODO: run app without internet  ( handle HTTP FAILED: java.net.UnknownHostException: Unable to resolve host "stepik.org": No address associated with hostname
        // TODO: handle others connection exceptions
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient.Builder()
            .addInterceptor(interceptor)
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