package com.fyrl29074.mainscreen.presentation.courseScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fyrl29074.mainscreen.presentation.CourseFormatter
import com.fyrl29074.mainscreen.presentation.CourseUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CourseViewModel(
    course: CourseUI,
) : ViewModel() {

    private val _state = MutableStateFlow<CourseScreenState>(CourseScreenState.Initializing)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = CourseScreenState.Content(course)
        }
    }

    fun addToFavourite(courseId: Int) {
        // TODO: implement with favourites screen

    }
}