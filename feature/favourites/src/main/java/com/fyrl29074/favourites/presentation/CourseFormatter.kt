package com.fyrl29074.favourites.presentation

import com.fyrl29074.model.domain.Course
import com.fyrl29074.model.presentation.CourseUI
import java.util.Calendar
import java.util.Locale

class CourseFormatter {

    fun format(course: Course): CourseUI {
        var day: String? = null
        var month: String? = null
        var year: String? = null

        if (course.createDate != null) {
            val calendar = Calendar.getInstance()
            calendar.time = course.createDate
            day = calendar.get(Calendar.DAY_OF_MONTH).toString()
            month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale("ru", "RU"))
            year = calendar.get(Calendar.YEAR).toString()
        }

        return CourseUI(
            id = course.id,
            title = course.title,
            summary = course.summary,
            description = course.description,
            imageUrl = course.imageUrl,
            price = course.price,
            displayPrice = course.displayPrice,
            dayOfMonth = day,
            monthName = month,
            year = year.toString(),
            createDate = course.createDate,
            courseUrl = course.courseUrl,
            isFavourite = course.isFavourite,
        )
    }

    fun format(course: CourseUI): Course {
        return Course(
            id = course.id,
            title = course.title,
            summary = course.summary,
            description = course.description,
            imageUrl = course.imageUrl,
            price = course.price,
            displayPrice = course.displayPrice,
            createDate = course.createDate,
            courseUrl = course.courseUrl,
            isFavourite = course.isFavourite,
        )
    }
}