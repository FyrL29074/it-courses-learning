package com.fyrl29074.mainscreen.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fyrl29074.mainscreen.R
import com.fyrl29074.mainscreen.databinding.ItemCourseBinding

// TODO: add pagination
class CourseAdapter(
    private val onFavouriteClick: (id: Int) -> Unit,
    private val onMoreDetailsClick: () -> Unit,
) : ListAdapter<CourseUI, CourseAdapter.CourseViewHolder>(courseDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = getItem(position)
        with(holder.binding) {
            Glide
                .with(itemCourse)
                .load(course.imageUrl)
                .into(image)

            addToFavourite.setOnClickListener { onFavouriteClick(course.id) }
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
            moreDetails.setOnClickListener { onMoreDetailsClick() }
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
