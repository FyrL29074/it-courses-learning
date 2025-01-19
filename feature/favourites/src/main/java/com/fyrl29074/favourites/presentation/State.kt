package com.fyrl29074.favourites.presentation

import com.fyrl29074.model.presentation.CourseUI

sealed class State {

    data object Initializing: State()

    data class Content(val courses: List<CourseUI>): State()
}