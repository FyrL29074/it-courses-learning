package com.fyrl29074.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment

interface Navigation {
    fun navigateToCourseScreen(fragment: Fragment, course: Bundle)

    fun back()
}