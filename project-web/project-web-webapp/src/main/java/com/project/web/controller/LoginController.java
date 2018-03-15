package com.project.web.controller;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.export.dto.user.UserExportDto;
import com.project.web.service.LoginService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**登录
 * Created by zhangzhen on 2017/9/8.
 */
@Controller
@RequestMapping("project")
public class LoginController {


    @Resource
    LoginService loginService;
    @RequestMapping("login")
    @ResponseBody
    public String login(UserExportDto userExportDto){
        ExecuteResult<UserExportDto> result=new ExecuteResult<UserExportDto>();
    try{
        result=loginService.login(userExportDto);
    }catch (Exception e){
        result.setErrorMessage(e.getMessage());
    }
        return JSONObject.fromObject(result).toString();
    }
}
