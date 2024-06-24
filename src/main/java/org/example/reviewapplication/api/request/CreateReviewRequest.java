package org.example.reviewapplication.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateReviewRequest {
    private final Long restaurantId;
    private final String content;
    private final Double Score;
}
