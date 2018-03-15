package com.project.web.service;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.export.dto.user.UserExportDto;

import java.util.List;

/**
 * Created by liwanpeng on 2017/7/29.
 */
public interface UserService {
    /**
     * 根据openid查询用户
     * @param openId
     * @return
     */
    public ExecuteResult<UserExportDto> selectByOpenId(String openId);

    /**
     * 新增用户
     * @param userExportDto
     * @return
     */
    public ExecuteResult<Integer> insertUser(UserExportDto userExportDto);

    /**
     * 根据用户id更新用户
     * @param userExportDto
     * @return
     */
    public ExecuteResult<Integer> updateUserByOpenId(UserExportDto userExportDto);
}
