package org.example.reviewapplication.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.BindParam;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class RestaurantDetailView {
    private final Long id;
    private final String name;
    private final String address;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
    private final List<Menu> menus;

    @AllArgsConstructor
    @Builder
    @Getter
    public static class Menu {
        private final Long id;
        private final String name;
        private final int price;
        private final ZonedDateTime createdAt;
        private final ZonedDateTime updatedAt;
    }
}
