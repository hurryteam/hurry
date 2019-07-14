package com.scnu.hurry.repository;

import com.scnu.hurry.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    /**
     * 查询本周数据
     * @param pageable
     * @return
     */
    @Transactional
    @Query(value = "SELECT * FROM report WHERE TO_DAYS(time) = TO_DAYS(NOW())",nativeQuery = true)
    Page<Report> findToday(Pageable pageable);

    /**
     * 查询本周数据
     * @param pageable
     * @return
     */
    @Transactional
    @Query(value = "SELECT * FROM report WHERE " +
            "YEARWEEK(date_format(time,'%Y-%m-%d')) = YEARWEEK(now())", nativeQuery = true)
    Page<Report> findThisWeek(Pageable pageable);

    /**
     * 查询本月数据
     * @param pageable
     * @return
     */
    @Transactional
    @Query(value = "SELECT * FROM report WHERE " +
            "DATE_FORMAT( time, '%Y%m' ) = DATE_FORMAT( CURDATE() , '%Y%m' )", nativeQuery = true)
    Page<Report> findThisMonth(Pageable pageable);

}
