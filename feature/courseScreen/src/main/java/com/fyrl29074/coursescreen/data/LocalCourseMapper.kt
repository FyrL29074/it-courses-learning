package com.fyrl29074.coursescreen.data

import com.fyrl29074.local.CourseEntity
import com.fyrl29074.model.domain.Course

class LocalCourseMapper {
    fun map(course: Course): CourseEntity {
        return CourseEntity(
            id = course.id,
            title = course.title,
            summary = course.summary,
            description = course.summary,
            imageUrl = course.imageUrl,
            price = course.price,
            displayPrice = course.displayPrice,
            createDate = course.createDate,
            courseUrl = course.courseUrl
        )
    }

    fun map(entity: CourseEntity): Course {
        return Course(
            id = entity.id,
            title = entity.title,
            summary = entity.summary,
            description = entity.summary,
            imageUrl = entity.imageUrl,
            price = entity.price,
            displayPrice = entity.displayPrice,
            createDate = entity.createDate,
            courseUrl = entity.courseUrl,
            isFavourite = true,
        )
    }
}
