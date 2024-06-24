package org.example.reviewapplication.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.reviewapplication.api.request.CreateReviewRequest;
import org.example.reviewapplication.service.ReviewService;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@Slf4j
public class ReviewApi {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public void createReview(
            @RequestBody CreateReviewRequest request
            ) {
        log.info("Received request: {}", request);
        reviewService.createReview(request);
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(
            @PathVariable("reviewId") Long reviewId
    ) {
        reviewService.deleteReview(reviewId);
    }
}
