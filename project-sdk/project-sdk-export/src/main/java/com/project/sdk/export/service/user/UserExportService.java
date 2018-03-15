package com.project.sdk.export.service.user;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.export.dto.user.UserExportDto;

/**
 * Created by liwanpeng on 2017/7/25.
 */
public interface UserExportService {
    /**
     * 新增user
     * @param userExportDto
     * @return
     */
    public ExecuteResult<Integer> insertUser(UserExportDto userExportDto);

    /**
     * 根据用户openid查询
     * @param openId
     * @return
     */
    public ExecuteResult<UserExportDto>  selectByOpenId(String openId);

    /**
     * 根据用户id更新
     * @param userExportDto
     * @return
     */
    public ExecuteResult<Integer> updateById(UserExportDto userExportDto);
}
