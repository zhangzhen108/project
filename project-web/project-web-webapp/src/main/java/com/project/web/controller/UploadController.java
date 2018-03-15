package com.project.web.controller;

import com.project.sdk.common.page.ExecuteResult;
import com.project.web.service.impl.FastDFSClientWrapper;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangzhen on 2017/9/10.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {


    @Resource
    FastDFSClientWrapper fastDFSClientWrapper;
    @RequestMapping(value = "/add")
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 省略业务逻辑代码。。。
        ExecuteResult<String> result = new ExecuteResult<String>();
        try {
            String imgUrl = fastDFSClientWrapper.uploadFile(file);

            imgUrl += "http://47.94.219.48:8888/" + imgUrl;
            result.setResult(imgUrl);
        } catch (Exception e) {
            result.setErrorMessage(JSONObject.fromObject(e).toString());
        }
        return JSONObject.fromObject(result).toString();
    }
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(String file){
        // 省略业务逻辑代码。。。
        ExecuteResult<String> result = new ExecuteResult<String>();
        try {
            fastDFSClientWrapper.deleteFile(file);
        } catch (Exception e) {
            result.setErrorMessage(JSONObject.fromObject(e).toString());
        }
        return JSONObject.fromObject(result).toString();
    }

}
