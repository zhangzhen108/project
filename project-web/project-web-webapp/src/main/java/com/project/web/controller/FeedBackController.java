package com.project.web.controller;

import com.project.sdk.export.dto.feedBack.FeedBackDto;
import com.project.sdk.export.service.FeedBack.FeedBackExportService;
import com.project.web.service.FeedBackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户反馈
 * Created by liwanpeng on 2017/9/13.
 */
@Controller
@RequestMapping("/project/feedBack")
public class FeedBackController {
    @Resource
    private FeedBackService feedBackService;
    /**
     * 添加用户反馈
     * @param param
     * @return
     */
    @RequestMapping("addFeedBack")
    @ResponseBody
    public int addFeedBack (FeedBackDto param){
        try {
            int i = feedBackService.addFeedBack(param);
            return i;
        }catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
}
