package com.fyrl29074.it_courses_learning

import android.app.Application
import com.fyrl29074.mainscreen.di.MainFeatureModule
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(MainFeatureModule)
        }
    }
}