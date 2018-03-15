package com.project.sdk.service;

import com.project.sdk.dto.user.User;

/**
 * Created by liwanpeng on 2017/7/25.
 */
public interface UserService {
    /**
     * 新增用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据用户openid查询
     * @param openId
     * @return
     */
    User selectByOpenId(String openId);

    /**
     * 根据用户id更新
     * @param user
     * @return
     */
    int updateById(User user);
}
