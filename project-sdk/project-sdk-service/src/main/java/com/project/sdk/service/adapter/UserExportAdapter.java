package com.project.sdk.service.adapter;

import com.alibaba.fastjson.JSON;
import com.project.sdk.common.ExecuteResult;
import com.project.sdk.common.Trans;
import com.project.sdk.dto.user.User;
import com.project.sdk.export.dto.user.UserExportDto;
import com.project.sdk.export.service.user.UserExportService;
import com.project.sdk.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * Created by liwanpeng on 2017/7/25.
 */
@Service("userExportService")
public class UserExportAdapter implements UserExportService {
    @Resource
    private  UserService userService;
    @Override
    public ExecuteResult<Integer> insertUser(UserExportDto userExportDto) {
        ExecuteResult<Integer> result=new ExecuteResult<Integer>();

        try {
            int insertNum=0;
            User user=new User();
            user=(User) Trans.transBeanToBeanDto(userExportDto,user);
            insertNum=userService.insertUser(user);
            result.setResult(insertNum);
        }catch (Exception e)
        {
            result.setErrorMessage(JSON.toJSONString(e));
        }
        return result;
    }

    @Override
    public ExecuteResult<UserExportDto> selectByOpenId(String openId) {
        ExecuteResult<UserExportDto> result=new ExecuteResult<UserExportDto>();
        try {

            User user=new User();
            user=userService.selectByOpenId(openId);
            if(user!=null) {
                UserExportDto userExportDto = new UserExportDto();
                userExportDto = (UserExportDto) Trans.transBeanToBeanDto(user, userExportDto);
                result.setResultCode(1);//1代表不用新增用户，查到了用户信息
                result.setSuccess(true);
                result.setResult(userExportDto);
            }
            else {
                result.setResultCode(0);//0代表没有查到用户信息，需要新增用户
                result.setResultMsg("没有查询到任何用户信息！");
                result.setSuccess(true);
            }
        }
        catch (Exception e){
            result.setErrorMessage(JSON.toJSONString(e));
        }
        return result;
    }

    @Override
    public ExecuteResult<Integer> updateById(UserExportDto userExportDto) {
        ExecuteResult<Integer> result=new ExecuteResult<Integer>();
        try {
            int updateNum=0;
            User user=new User();
            user=(User)Trans.transBeanToBeanDto(userExportDto,user);

            updateNum=userService.updateById(user);
            result.setResult(updateNum);
        }
        catch (Exception e){
            result.setErrorMessage(JSON.toJSONString(e));
        }
        return result;
    }
}
