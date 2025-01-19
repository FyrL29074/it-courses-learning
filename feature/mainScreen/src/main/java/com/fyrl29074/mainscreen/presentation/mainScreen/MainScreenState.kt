package com.fyrl29074.mainscreen.presentation.mainScreen

import com.fyrl29074.model.presentation.CourseUI

sealed class MainScreenState {

    data object Initializing : MainScreenState()

    data class Content(val courses: List<CourseUI>) : MainScreenState()
}