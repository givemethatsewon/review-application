package org.example.reviewapplication.api;

import lombok.RequiredArgsConstructor;
import org.example.reviewapplication.api.request.CreateAndEditRestaurantRequest;
import org.example.reviewapplication.api.response.RestaurantDetailView;
import org.example.reviewapplication.api.response.RestaurantView;
import org.example.reviewapplication.model.RestaurantEntity;
import org.example.reviewapplication.model.ReviewEntity;
import org.example.reviewapplication.repository.ReviewRepository;
import org.example.reviewapplication.service.RestaurantService;
import org.example.reviewapplication.service.ReviewService;
import org.example.reviewapplication.service.dto.ReviewDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantApi {
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurants/{restaurantId}")
    public RestaurantDetailView getRestaurant(
            @PathVariable Long restaurantId
    ) {
        return restaurantService.getRestaurantDetail(restaurantId);
    }

    @PostMapping("/restaurants")
    public RestaurantEntity createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
            ) {
        return restaurantService.createdRestaurant(request);
    }

    @PutMapping("/restaurants/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        restaurantService.editRestaurant(restaurantId, request);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(
            @PathVariable Long restaurantId
    ) {
        restaurantService.deleteRestaurant(restaurantId);
    }
    @GetMapping("/restaurants/{restaurantId}/reviews")
    public ReviewDto getRestaurantReviews(
            @PathVariable("restaurantId") Long restaurantId,
            @RequestParam("offset") Integer offset,
            @RequestParam("limit") Integer limit
    ) {

        return reviewService.getRestaurantReviews(restaurantId, PageRequest.of(offset / limit, limit));
    }
}
