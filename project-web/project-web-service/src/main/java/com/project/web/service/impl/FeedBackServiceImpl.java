package com.project.web.service.impl;

import com.project.sdk.export.dto.feedBack.FeedBackDto;
import com.project.sdk.export.service.FeedBack.FeedBackExportService;
import com.project.web.service.FeedBackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liwanpeng on 2017/9/13.
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Resource
    private FeedBackExportService feedBackExportService;
    @Override
    public int addFeedBack(FeedBackDto param) {
        int i = feedBackExportService.addFeedBack(param);
        return i;
    }
}
