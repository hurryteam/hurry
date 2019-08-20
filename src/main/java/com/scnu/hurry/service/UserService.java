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
     * 通过openid查询用户头像
     * @param openid
     * @return
     */
    String findUserPictureByOpenid(String openid);
    /*
     * 增加用户信息
     * @param openid
     */
    void addUser(String openid, String url);

}
