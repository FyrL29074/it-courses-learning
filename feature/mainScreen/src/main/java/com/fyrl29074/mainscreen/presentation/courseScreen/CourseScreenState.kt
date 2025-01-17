package com.fyrl29074.mainscreen.presentation.courseScreen

import com.fyrl29074.mainscreen.presentation.CourseUI

sealed class CourseScreenState {

    data object Initializing : CourseScreenState()

    data class Content(val course: CourseUI) : CourseScreenState()
}