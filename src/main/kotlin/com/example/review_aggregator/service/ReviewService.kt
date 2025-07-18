package com.example.review_aggregator.service

import com.example.review_aggregator.dto.ReviewCreateDTO
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import com.example.review_aggregator.repository.ReviewRepository
import com.example.review_aggregator.entity.Review
import java.time.LocalDateTime

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val restTemplate: RestTemplate
) {
    fun getAllReviews(): List<Review> = reviewRepository.findAll()

    fun importReviews() {
        val response = restTemplate.getForObject("https://mockapi.io/reviews", Array<ReviewCreateDTO>::class.java)

        val reviews = response?.map { dto ->
            Review(
                author = dto.author,
                rating = dto.rating,
                content = dto.content,
                createdAt = dto.createdAt,
            )
        }

        if (!reviews.isNullOrEmpty()) {
            reviewRepository.saveAll(reviews)
        }
    }

    fun search(
        author: String?,
        minRating: Int?,
        maxRating: Int?,
        since: LocalDateTime?
    ): List<Review> = reviewRepository.search(author, minRating, maxRating, since)
}
