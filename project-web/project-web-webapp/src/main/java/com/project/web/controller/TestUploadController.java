package com.project.web.controller;

import com.project.web.service.impl.FastDFSClientWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangzhen on 2017/7/12.
 */
@Controller
public class TestUploadController {
    @Resource
    FastDFSClientWrapper fastDFSClientWrapper;
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 省略业务逻辑代码。。。
        try{
            String imgUrl = fastDFSClientWrapper.uploadFile(file);
            System.out.print("地址是---------------------------------==http://47.94.219.48:8888/"+imgUrl);
        }catch (Exception e){
            e.printStackTrace();
        }

        // 。。。。
        return "";

    }
    @RequestMapping(value = "/indexUpload111")
    public String indexUpload() {

        return "welcome";

    }
}
