package org.example.reviewapplication.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class CreateReviewRequest {
    private final Long restaurantId;
    private final String content;
    private final Double score;
}
