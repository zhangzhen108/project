package com.project.sdk.service;

import com.project.sdk.dto.user.User;
import com.project.sdk.export.dto.user.UserExportDto;
import com.project.sdk.export.service.user.UserExportService;

/**
 * Created by zhangzhen on 2017/9/8.
 */
public interface LoginService {

    public User login(User user);
}
