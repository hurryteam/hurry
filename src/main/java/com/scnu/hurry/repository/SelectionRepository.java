package com.scnu.hurry.repository;


import com.scnu.hurry.entity.Selection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectionRepository extends JpaRepository<Selection, Integer> {

    /**
     * 根据用户选择的课程
     * @param pageable
     * @return
     */
    Page<Selection> findAllByUserId(Integer userId, Pageable pageable);
}
