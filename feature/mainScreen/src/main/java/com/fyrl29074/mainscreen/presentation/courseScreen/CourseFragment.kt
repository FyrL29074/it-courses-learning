package com.fyrl29074.mainscreen.presentation.courseScreen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.fyrl29074.mainscreen.R
import com.fyrl29074.mainscreen.databinding.FragmentCourseBinding
import com.fyrl29074.mainscreen.presentation.CourseUI
import com.fyrl29074.navigation.Navigation
import kotlinx.coroutines.launch
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel

class CourseFragment : Fragment() {

    private var _binding: FragmentCourseBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CourseViewModel by viewModel {
        val course: CourseUI? = arguments?.getParcelable("course")
        parametersOf(course)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFlow()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupUI(course: CourseUI) {
        val navigation: Navigation = (requireActivity() as Navigation)

        with(binding) {
            Glide.with(root)
                .load(course.imageUrl)
                .into(image)

            back.setOnClickListener { navigation.back() }
            addToFavourite.setOnClickListener { viewModel.addToFavourite(course.id) }
            rating.text = "n.nn" // todo: get rating from api
            val formattedDate = getString(
                R.string.create_date,
                course.dayOfMonth,
                course.monthName,
                course.year
            )
            date.text = formattedDate
            title.text = course.title
            authorAvatar // todo: find api for authorAvatar + add glide here
            author.text = "author" // todo: add author to api
            startCourse.setOnClickListener { openCourseUrl(course.courseUrl) }
            goToPlatform.setOnClickListener { openCourseUrl(course.courseUrl) }
            description.text = course.description
        }
    }

    private fun openCourseUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun initFlow() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    CourseScreenState.Initializing -> {}
                    is CourseScreenState.Content -> {
                        setupUI(state.course)
                    }
                }
            }
        }
    }
}