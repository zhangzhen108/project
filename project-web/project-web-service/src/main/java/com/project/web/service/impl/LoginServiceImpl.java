package com.project.web.service.impl;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.export.dto.user.UserExportDto;
import com.project.sdk.export.service.login.LoginExportService;
import com.project.web.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangzhen on 2017/9/8.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Resource
    LoginExportService loginExportService;
    @Override
    public ExecuteResult<UserExportDto> login(UserExportDto userExportDto) {
        ExecuteResult<UserExportDto> result=loginExportService.login(userExportDto);
        return result;
    }
}
