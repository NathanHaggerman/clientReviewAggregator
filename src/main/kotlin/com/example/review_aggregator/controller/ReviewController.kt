package com.example.review_aggregator.controller

import com.example.review_aggregator.dto.ReviewResponseDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import com.example.review_aggregator.service.ReviewService
import java.time.LocalDateTime

@RestController
@RequestMapping("/reviews")
class ReviewController(private val reviewService: ReviewService) {

    @GetMapping
    fun search(
        @RequestParam(required = false) author: String?,
        @RequestParam(required = false) minRating: Int?,
        @RequestParam(required = false) maxRating: Int?,
        @RequestParam(required = false) since: LocalDateTime?,
    ): List<ReviewResponseDTO> {
        return reviewService.search(author, minRating, maxRating, since)
            .map { r -> ReviewResponseDTO(r.id!!, r.author, r.content, r.rating, r.createdAt) }
    }

    @PostMapping
    fun importReviews() = reviewService.importReviews()
}