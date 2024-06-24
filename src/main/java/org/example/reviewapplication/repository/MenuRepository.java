package org.example.reviewapplication.repository;

import org.example.reviewapplication.model.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    public List<MenuEntity> findAllByRestaurantId(Long restaurantId);
}
