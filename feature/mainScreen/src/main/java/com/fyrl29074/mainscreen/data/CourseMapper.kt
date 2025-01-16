package com.fyrl29074.mainscreen.data

import com.fyrl29074.mainscreen.domain.Course
import com.fyrl29074.network.model.CourseDto
import java.text.SimpleDateFormat
import java.util.Locale

class CourseMapper {
    fun map(dto: CourseDto): Course {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val createDate = inputFormat.parse(dto.createDate)

        return Course(
            id = dto.id,
            title = dto.title,
            summary = dto.summary,
            description = dto.summary,
            imageUrl = dto.imageUrl,
            price = dto.price,
            displayPrice = dto.displayPrice,
            createDate = createDate,
        )
    }
}