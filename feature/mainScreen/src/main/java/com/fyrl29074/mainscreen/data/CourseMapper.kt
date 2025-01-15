package com.fyrl29074.mainscreen.data

import com.fyrl29074.mainscreen.domain.Course
import com.fyrl29074.network.model.CourseDto

class CourseMapper {
    fun map(dto: CourseDto): Course {
        return Course(
            id = dto.id,
            title = dto.title,
            summary = dto.summary,
            description = dto.summary,
            imageUrl = dto.imageUrl,
            displayPrice = dto.displayPrice,
            createData = dto.createData,
            updateData = dto.updateData,
        )
    }
}