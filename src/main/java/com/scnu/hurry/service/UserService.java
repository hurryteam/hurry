package com.scnu.hurry.service;

import java.util.List;

public interface UserService {
    /**
     * 查找是否存在用户
     * @param openid
     * @return 是否成功
     */
    boolean findUser(String openid);

    /*
     * 通过userId查询用户头像
     * @param userId
     * @return
     */
    String findUserPictureByUserId(Integer userId);
    /*
     * 增加用户信息
     * @param openid
     */
    void addUser(String openid, String url);

    /*
     * @通过userid查询用户头像
     * @param userid
     */
    List<String> findAllUserPictureByUserid(List<Integer> userids);

}
