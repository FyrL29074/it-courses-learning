package com.fyrl29074.favourites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fyrl29074.favourites.domain.AddToFavouritesUseCase
import com.fyrl29074.favourites.domain.DeleteFromFavouritesUseCase
import com.fyrl29074.favourites.domain.GetFavouritesCourseUseCase
import com.fyrl29074.model.presentation.CourseUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavouritesViewModel(
    private val getFavouritesCourseUseCase: GetFavouritesCourseUseCase,
    private val deleteFromFavouritesUseCase: DeleteFromFavouritesUseCase,
    private val addToFavouritesUseCase: AddToFavouritesUseCase,
    private val courseFormatter: CourseFormatter,
) : ViewModel() {

    private val _state = MutableStateFlow<State>(State.Initializing)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getFavouritesCourseUseCase.execute().collect { courses ->
                _state.value = State.Content(courses.map(courseFormatter::format))
            }
        }
    }

    fun onFavouriteClick(course: CourseUI) {
        viewModelScope.launch {
            if (course.isFavourite) {
                deleteFromFavouritesUseCase.execute(course.id)
            } else {
                addToFavouritesUseCase.execute(courseFormatter.format(course))
            }
        }
    }
}