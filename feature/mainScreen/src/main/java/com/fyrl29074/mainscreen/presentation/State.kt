package com.fyrl29074.mainscreen.presentation

sealed class State {

    data object Initializing : State()

    data class Content(val courses: List<CourseUI>) : State()
}