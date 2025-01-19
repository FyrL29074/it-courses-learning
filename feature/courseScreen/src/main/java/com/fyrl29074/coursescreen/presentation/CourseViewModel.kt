package com.fyrl29074.coursescreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fyrl29074.coursescreen.domain.AddToFavouritesUseCase
import com.fyrl29074.coursescreen.domain.DeleteFromFavouritesUseCase
import com.fyrl29074.model.presentation.CourseUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CourseViewModel(
    course: CourseUI,
    private val addToFavouritesUseCase: AddToFavouritesUseCase,
    private val deleteFromFavouritesUseCase: DeleteFromFavouritesUseCase,
    private val courseFormatter: CourseFormatter,
) : ViewModel() {

    private val _state = MutableStateFlow<CourseScreenState>(CourseScreenState.Initializing)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = CourseScreenState.Content(course)
        }
    }

    fun addToFavourite(course: CourseUI) {
        viewModelScope.launch {
            addToFavouritesUseCase.execute(courseFormatter.format(course))
        }
    }

    fun deleteFromFavourites(id: Int) {
        viewModelScope.launch {
            deleteFromFavouritesUseCase.execute(id)
        }
    }
}