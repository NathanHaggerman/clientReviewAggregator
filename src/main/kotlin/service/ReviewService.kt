package service

import dto.ReviewCreateDTO
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import repository.ReviewRepository
import entity.Review

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
}