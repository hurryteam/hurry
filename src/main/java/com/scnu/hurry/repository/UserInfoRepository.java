package com.scnu.hurry.repository;


import com.scnu.hurry.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    UserInfo findByOpenid(String openid);
    UserInfo findByUserId(Integer userId);
}
