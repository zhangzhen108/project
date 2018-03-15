package com.project.sdk.service.impl;

import com.project.sdk.dto.user.User;
import com.project.sdk.export.dto.user.UserExportDto;
import com.project.sdk.service.LoginService;
import com.project.sdk.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangzhen on 2017/9/8.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Resource
    UserService userService;
    @Override
    public User login(User user){
        if(user==null|| StringUtils.isEmpty(user.getOpenid())){
            throw new RuntimeException("oppenId is null");
        }
        User resultUser=userService.selectByOpenId(user.getOpenid());
        if(resultUser!=null){
            return resultUser;
        }else{
            int resultInsertUser=userService.insertUser(user);
            User result=userService.selectByOpenId(user.getOpenid());
            return result;
        }
    }
}
