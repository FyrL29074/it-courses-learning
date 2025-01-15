package com.fyrl29074.mainscreen.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fyrl29074.mainscreen.databinding.ItemCourseBinding
import com.fyrl29074.mainscreen.domain.Course

// TODO: add pagination
class CourseAdapter(
    private val onFavouriteClick: (id: Int) -> Unit,
    private val onMoreDetailsClick: () -> Unit,
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private val courses = mutableListOf<Course>()

    // It's okay, while no pagination and and it's hidden from user
    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<Course>) {
        courses.clear()
        courses.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun getItemCount(): Int = courses.size

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        with(holder.binding) {
            Glide
                .with(itemCourse)
                .load(course.imageUrl)
                .into(image)

            addToFavourite.setOnClickListener { onFavouriteClick(course.id) }
            // TODO: it should be from API, but there is no this information
            rating.text = "n.nn"
            date.text = course.updateData
            title.text = course.title
            summary.text = course.summary
            price.text = course.displayPrice
            moreDetails.setOnClickListener { onMoreDetailsClick() }
        }
    }

    inner class CourseViewHolder(val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root)
}
