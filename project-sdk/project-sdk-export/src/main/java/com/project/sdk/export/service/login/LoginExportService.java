package com.project.sdk.export.service.login;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.export.dto.user.UserExportDto;

/**
 * Created by zhangzhen on 2017/9/8.
 */
public interface LoginExportService {

    public ExecuteResult<UserExportDto> login(UserExportDto userExportDto);
}
