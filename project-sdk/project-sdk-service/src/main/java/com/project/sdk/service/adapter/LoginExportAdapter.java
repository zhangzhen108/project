package com.project.sdk.service.adapter;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.common.Trans;
import com.project.sdk.dto.user.User;
import com.project.sdk.export.dto.user.UserExportDto;
import com.project.sdk.export.service.login.LoginExportService;
import com.project.sdk.service.LoginService;
import com.project.sdk.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangzhen on 2017/9/8.
 */
@Service("loginExportService")
public class LoginExportAdapter implements LoginExportService{

    @Resource
    LoginService loginService;
    @Override
    public ExecuteResult<UserExportDto> login(UserExportDto userExportDto){
        ExecuteResult<UserExportDto> result=new ExecuteResult<UserExportDto>();
      try{

          User user=new User();
          user=(User) Trans.transBeanToBeanDto(userExportDto, user);
          User resultUser=loginService.login(user);
          UserExportDto resultUserExport=new UserExportDto();
          resultUserExport = (UserExportDto) Trans.transBeanToBeanDto(resultUser, resultUserExport);
          result.setResult(resultUserExport);
      }catch (Exception e){
          result.setErrorMessage(e.getMessage());
      }
        return result;
    }
}
