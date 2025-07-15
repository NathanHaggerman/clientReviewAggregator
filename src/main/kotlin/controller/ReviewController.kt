package controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import service.ReviewService

@RestController
@RequestMapping("/reviews")
class ReviewController(private val reviewService: ReviewService) {

    @GetMapping
    fun getAll() = reviewService.getAll()
}