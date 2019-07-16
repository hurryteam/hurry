package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    /**
     * 用户查询本周数据
     */
    @Transactional
    @Query(value = "SELECT * FROM report WHERE user_id = ? and TO_DAYS(time) = TO_DAYS(NOW())", nativeQuery = true)
    List<Report> findToday(Integer userId);

    /**
     * 用户查询本周数据
     */
    @Transactional
    @Query(value = "SELECT * FROM report WHERE user_id = ? and " +
            "YEARWEEK(date_format(time,'%Y-%m-%d')) = YEARWEEK(now())", nativeQuery = true)
    List<Report> findThisWeek(Integer userId);

    /**
     * 用户查询本月数据
     */
    @Transactional
    @Query(value = "SELECT * FROM report WHERE user_id = ? and " +
            "DATE_FORMAT( time, '%Y%m' ) = DATE_FORMAT( CURDATE() , '%Y%m' )", nativeQuery = true)
    List<Report> findThisMonth(Integer userId);

}
