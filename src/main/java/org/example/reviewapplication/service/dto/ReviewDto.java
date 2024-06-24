package org.example.reviewapplication.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.reviewapplication.model.ReviewEntity;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ReviewDto {
    private Double avgScore;
    private List<ReviewEntity> reviews;
    private ReviewDtoPage page;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReviewDtoPage {
        private Integer offset; // 조회할 데이터의 시작 위치
        private Integer limit; // 한번에 조회할 최대 행의 수
    }
}
