package com.fyrl29074.mainscreen.presentation.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fyrl29074.mainscreen.domain.GetCoursesUseCase
import com.fyrl29074.mainscreen.presentation.CourseFormatter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date

class MainViewModel(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val courseFormatter: CourseFormatter,
) : ViewModel() {

    private val _state = MutableStateFlow<MainScreenState>(MainScreenState.Initializing)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val courses = getCoursesUseCase.execute().map(courseFormatter::format)
            _state.value = MainScreenState.Content(courses)
            sortByDateAscending()
        }
    }

    fun sortByDateAscending() {
        if (state.value is MainScreenState.Content) {
            val sortedList =
                (state.value as MainScreenState.Content).courses.sortedBy { it.createDate ?: Date(0) }
            _state.value = MainScreenState.Content(sortedList)
        }
    }

    fun sortByDateDescending() {
        if (state.value is MainScreenState.Content) {
            val sortedList = (state.value as MainScreenState.Content).courses.sortedByDescending {
                it.createDate ?: Date(0)
            }
            _state.value = MainScreenState.Content(sortedList)
        }
    }

    fun sortByRating() {
        // TODO: copy code from sort by price, when rating will be in API
        // maybe  get /api/course-review-summaries  is my way
    }

    fun sortByPriceAscending() {
        if (state.value is MainScreenState.Content) {
            val sortedList = (state.value as MainScreenState.Content).courses.sortedBy { it.price }
            _state.value = MainScreenState.Content(sortedList)
        }
    }

    fun sortByPriceDescending() {
        if (state.value is MainScreenState.Content) {
            val sortedList = (state.value as MainScreenState.Content).courses.sortedByDescending { it.price }
            _state.value = MainScreenState.Content(sortedList)
        }
    }

    fun onFavouriteClick(id: Int) {
        // TODO: will be implemented with favourites screen
        TODO("will be implemented with favourites screen")
    }
}