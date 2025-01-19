package com.fyrl29074.coursescreen.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.fyrl29074.coursescreen.databinding.FragmentCourseBinding
import com.fyrl29074.model.presentation.CourseUI
import com.fyrl29074.navigation.Navigation
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CourseFragment : Fragment() {

    private var _binding: FragmentCourseBinding? = null
    private val binding get() = _binding!!

    private var isFavourite: Boolean = false

    private val viewModel: CourseViewModel by viewModel {
        val course: CourseUI? = arguments?.getParcelable("course")
        isFavourite = course?.isFavourite ?: false
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
            addToFavourite.setOnClickListener { onFavouriteClick(course) }
            val favouriteIconRes =
                if (isFavourite) {
                    com.fyrl29074.ui_kit.R.drawable.ic_favourites_green_filled
                } else {
                    com.fyrl29074.ui_kit.R.drawable.ic_favourites_dark
                }
            binding.addToFavourite.setImageResource(favouriteIconRes)

            rating.text = "n.nn" // todo: get rating from api
            val formattedDate = getString(
                com.fyrl29074.ui_kit.R.string.create_date,
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

    private fun updateFavouriteIcon() {
        val iconRes =
            if (isFavourite) {
                com.fyrl29074.ui_kit.R.drawable.ic_favourites_dark
            } else {
                com.fyrl29074.ui_kit.R.drawable.ic_favourites_green_filled
            }

        binding.addToFavourite.setImageResource(iconRes)
    }

    private fun onFavouriteClick(course: CourseUI) {
        if (isFavourite) {
            viewModel.deleteFromFavourites(course.id)
            updateFavouriteIcon()
            isFavourite = false
        } else {
            viewModel.addToFavourite(course)
            updateFavouriteIcon()
            isFavourite = true
        }
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