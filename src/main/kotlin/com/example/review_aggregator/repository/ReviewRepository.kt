package com.example.review_aggregator.repository

import com.example.review_aggregator.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDateTime

interface ReviewRepository : JpaRepository<Review, Long> {
    @Query("""
        SELECT r FROM Review r
        WHERE (:author IS NULL OR r.author = :author)
        AND (:minRating IS NULL OR r.rating >= :minRating)
        AND (:maxRating IS NULL OR r.rating <= :maxRating)
        AND (:since IS NULL OR r.createdAt >= :since)
    """)
    fun search(
        @Param("author") author: String?,
        @Param("minRating") minRating: Int?,
        @Param("maxRating") maxRating: Int?,
        @Param("since") since: LocalDateTime?
    ): List<Review>
}