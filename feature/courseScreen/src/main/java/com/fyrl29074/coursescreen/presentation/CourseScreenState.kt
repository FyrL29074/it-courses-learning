package com.fyrl29074.coursescreen.presentation

import com.fyrl29074.model.presentation.CourseUI

sealed class CourseScreenState {

    data object Initializing : CourseScreenState()

    data class Content(val course: CourseUI) : CourseScreenState()
}