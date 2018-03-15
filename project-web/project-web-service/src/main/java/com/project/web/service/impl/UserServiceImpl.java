package com.project.web.service.impl;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.export.dto.user.UserExportDto;
import com.project.sdk.export.service.user.UserExportService;
import com.project.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by liwanpeng on 2017/7/29.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserExportService userExportService;

    @Override
    public ExecuteResult<UserExportDto> selectByOpenId(String openId) {
       ExecuteResult<UserExportDto> userExportDtoExecuteResult=new ExecuteResult<UserExportDto>();
       userExportDtoExecuteResult=userExportService.selectByOpenId(openId);
        return userExportDtoExecuteResult;
    }

    @Override
    public ExecuteResult<Integer> insertUser(UserExportDto userExportDto) {
        ExecuteResult<Integer> insertNum=new ExecuteResult<Integer>();
        ExecuteResult<UserExportDto> userExportDtoExecuteResult=new ExecuteResult<UserExportDto>();
        insertNum=userExportService.insertUser(userExportDto);
        return insertNum;
    }

    @Override
    public ExecuteResult<Integer> updateUserByOpenId(UserExportDto userExportDto) {
        ExecuteResult<Integer> updateNum=new ExecuteResult<Integer>();
        updateNum=userExportService.updateById(userExportDto);
        return updateNum;
    }
}
