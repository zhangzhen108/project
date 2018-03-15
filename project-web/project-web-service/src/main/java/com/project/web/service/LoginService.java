package com.project.web.service;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.export.dto.user.UserExportDto;

/**
 * Created by Administrator on 2017/9/10.
 */
public interface LoginService {


    public ExecuteResult<UserExportDto> login(UserExportDto userExportDto);
}
