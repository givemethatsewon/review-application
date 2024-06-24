package org.example.reviewapplication.api;

import lombok.RequiredArgsConstructor;
import org.example.reviewapplication.api.request.CreateReviewRequest;
import org.example.reviewapplication.service.ReviewService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReviewApi {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public void createReview(
            @RequestBody CreateReviewRequest request
            ) {
        reviewService.createReview(request.getRestaurantId(), request.getContent(), request.getScore());
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(
            @PathVariable("reviewId") Long reviewId
    ) {
        reviewService.deleteReview(reviewId);
    }
}
