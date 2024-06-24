package org.example.reviewapplication.service;


import lombok.RequiredArgsConstructor;
import org.example.reviewapplication.api.request.CreateReviewRequest;
import org.example.reviewapplication.model.ReviewEntity;
import org.example.reviewapplication.repository.RestaurantRepository;
import org.example.reviewapplication.repository.ReviewRepository;
import org.example.reviewapplication.service.dto.ReviewDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class ReviewService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void createReview(CreateReviewRequest request) {
        restaurantRepository.findById(request.getRestaurantId()).orElseThrow();

        ReviewEntity review = ReviewEntity.builder()
                .restaurantId(request.getRestaurantId())
                .content(request.getContent())
                .score(request.getScore())
                .build();

        reviewRepository.save(review);
    }

    @Transactional
    public void deleteReview(Long reviewId) {
        ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();

        reviewRepository.delete(review);
    }

    public ReviewDto getRestaurantReviews(Long restaurantId, Pageable page) {
        Double avgScore = reviewRepository.getAvgScoreByRestaurantId(restaurantId);
        Slice<ReviewEntity> reviews = reviewRepository.findSliceByRestaurantId(restaurantId, page);

        return ReviewDto.builder()
                .avgScore(avgScore)
                .reviews(reviews.getContent())
                .page(
                        ReviewDto.ReviewDtoPage.builder()
                                .offset(page.getPageNumber() * page.getPageSize())
                                .limit(page.getPageSize())
                                .build()
                )
                .build();
    }
}
