package org.example.reviewapplication.repository;

import org.example.reviewapplication.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>{

}
