package com.fyrl29074.mainscreen.presentation

import com.fyrl29074.mainscreen.domain.Course

sealed class State {

    data object Initializing : State()

    data class Content(val courses: List<Course>) : State()
}