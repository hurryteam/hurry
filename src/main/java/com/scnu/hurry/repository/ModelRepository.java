package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    Model findByUserId(Integer userId);
}
