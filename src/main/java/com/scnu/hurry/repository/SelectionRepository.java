package com.scnu.hurry.repository;


import com.scnu.hurry.entity.Selection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectionRepository extends JpaRepository<Selection, Integer> {

    /**
     * 根据用户选择的课程
     * @return
     */
    List<Selection> findAllByUserId(Integer userId);
}
