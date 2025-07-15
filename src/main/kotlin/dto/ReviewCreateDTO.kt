package dto

import java.time.LocalDateTime

data class ReviewCreateDTO(
    val author: String,
    val content: String,
    val rating: Int,
    val createdAt: LocalDateTime
)