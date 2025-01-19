package com.fyrl29074.favourites.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import com.fyrl29074.CourseAdapter
import com.fyrl29074.favourites.databinding.FragmentFavouritesBinding
import com.fyrl29074.model.presentation.CourseUI
import com.fyrl29074.navigation.Navigation
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouritesFragment : Fragment() {

    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavouritesViewModel by viewModel()

    private val adapter by lazy {
        CourseAdapter(
            onFavouriteClick = viewModel::onFavouriteClick,
            onMoreDetailsClick = { course -> onMoreDetailsClick(course) },
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.courseList.adapter = adapter
        initFlow()
    }

    private fun initFlow() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    State.Initializing -> {}
                    is State.Content -> adapter.submitList(state.courses)
                }
            }
        }
    }

    private fun onMoreDetailsClick(course: CourseUI) {
        val bundle = bundleOf("course" to course)
        (requireActivity() as Navigation).navigateToCourseScreen(
            fragment = this,
            bundle,
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}