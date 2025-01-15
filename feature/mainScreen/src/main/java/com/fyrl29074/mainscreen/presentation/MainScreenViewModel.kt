package com.fyrl29074.mainscreen.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fyrl29074.mainscreen.domain.GetCoursesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getCoursesUseCase: GetCoursesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<State>(State.Initializing)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val courses = getCoursesUseCase.execute()
            _state.value = State.Content(courses)
        }
    }

    fun onFavouriteClick(id: Int) {
        Log.d("Olegkim0", "MainScreenViewModel::onFavouriteClick id = $id")
    }

    fun onMoreDetailsClick() {
        Log.d("Olegkim0", "MainScreenViewModel::onMoreDetailsClick ")
    }
}