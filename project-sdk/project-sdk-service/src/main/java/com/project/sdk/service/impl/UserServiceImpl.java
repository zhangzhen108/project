package com.project.sdk.service.impl;


import com.project.sdk.dto.user.User;
import com.project.sdk.mapper.user.UserMapper;
import com.project.sdk.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户实现
 * Created by liwanpeng on 2017/7/25.
 */
@Service
public class UserServiceImpl implements UserService{


    @Resource
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        int insertNum=0;
        insertNum=userMapper.insert(user);
        return insertNum;
    }

    @Override
    public User selectByOpenId(String openId) {
        User user=new User();
        user=userMapper.selectByOpenId(openId);
        return user;
    }

    @Override
    public int updateById(User user) {
        int updateNum=0;
        updateNum=userMapper.updateByPrimaryKey(user);
        return updateNum;
    }

}
