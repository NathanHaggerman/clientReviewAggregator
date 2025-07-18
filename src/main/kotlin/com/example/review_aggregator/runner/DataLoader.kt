package com.example.review_aggregator.runner

import com.example.review_aggregator.entity.Review
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import com.example.review_aggregator.repository.ReviewRepository
import java.time.LocalDateTime

@Component
class DataLoader(private val reviewRepository: ReviewRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (reviewRepository.count() == 0L) {
            val reviews = listOf(
                Review(author = "Alice", rating = 5, content = "Awesome product!", createdAt = LocalDateTime.now().minusDays(2)),
                Review(author = "Bob", rating = 3, content = "It's okay.", createdAt = LocalDateTime.now().minusDays(1)),
                Review(author = "Charlie", rating = 1, content = "Did not like it.", createdAt = LocalDateTime.now().minusHours(5))
            )
            reviewRepository.saveAll(reviews)
            println("Sample reviews loaded")
        }
    }
}
