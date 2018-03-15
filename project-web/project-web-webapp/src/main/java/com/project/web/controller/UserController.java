package com.project.web.controller;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.export.dto.user.UserExportDto;
import com.project.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liwanpeng on 2017/7/29.
 */
@RestController
@RequestMapping("project/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("selectByOpenId")
    @ResponseBody
    public ExecuteResult<UserExportDto> selectByOpenId(String openId){
        ExecuteResult<UserExportDto> result=new ExecuteResult<UserExportDto>();
        result=userService.selectByOpenId(openId);
        return result;
        }
    @RequestMapping(value = "addUser",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public ExecuteResult<Integer> addUser(@RequestBody UserExportDto user) {
        ExecuteResult<Integer> result = new ExecuteResult<Integer>();
        try {
            result=userService.insertUser(user);
            return result;
        }catch (Exception e)
        {
            result.setErrorMessage("失败");
            e.printStackTrace();
            return result;
        }
    }
    @RequestMapping("updateUser")
    @ResponseBody
    public ExecuteResult<Integer> updateUser(UserExportDto user){
        ExecuteResult<Integer> result =new ExecuteResult<Integer>();
        result=userService.updateUserByOpenId(user);
        return  result;
    }
}

