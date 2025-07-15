package dto

import java.time.LocalDateTime

data class ReviewResponseDTO(
    val id: Long,
    val author: String,
    val content: String,
    val rating: Int,
    val createdAt: LocalDateTime
)