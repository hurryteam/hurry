package com.scnu.hurry.service;

public interface UserService {
    /**
     * 查找是否存在用户
     * @param openid
     * @return
     */
    boolean findUser(String openid);

    /**
     * 查询用户头像
     * @param openid
     * @return
     */
    String findUserPicture(String openid);
}
