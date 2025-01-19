package com.fyrl29074

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fyrl29074.model.presentation.CourseUI
import com.fyrl29074.ui_kit.R
import com.fyrl29074.ui_kit.databinding.ItemCourseBinding

// TODO: add pagination
class CourseAdapter(
    private val onFavouriteClick: (course: CourseUI) -> Unit,
    private val onMoreDetailsClick: (course: CourseUI) -> Unit,
) : ListAdapter<CourseUI, CourseAdapter.CourseViewHolder>(courseDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = getItem(position)
        with(holder.binding) {
            Glide.with(itemCourse)
                .load(course.imageUrl)
                .into(image)

            addToFavourite.setOnClickListener { onFavouriteClick(course) }
            if (course.isFavourite) {
                addToFavourite.setImageResource(R.drawable.ic_favourites_green_filled)
            } else {
                addToFavourite.setImageResource(R.drawable.ic_favourites_white)
            }
            rating.text = "n.nn" // TODO: need to get from API
            val formattedDate = root.context.getString(
                R.string.create_date,
                course.dayOfMonth,
                course.monthName,
                course.year
            )
            date.text = formattedDate
            title.text = course.title
            summary.text = course.summary
            if (course.price == 0f) {
                price.visibility = View.INVISIBLE
            } else {
                price.isVisible = true
                price.text = course.displayPrice
            }
            moreDetails.setOnClickListener { onMoreDetailsClick(course) }
        }
    }

    inner class CourseViewHolder(val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root)
}

private val courseDiffUtilCallback = object : DiffUtil.ItemCallback<CourseUI>() {
    override fun areItemsTheSame(oldItem: CourseUI, newItem: CourseUI): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CourseUI, newItem: CourseUI): Boolean {
        return oldItem == newItem
    }
}