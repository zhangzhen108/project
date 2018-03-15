package com.project.sdk.service.adapter;

import com.project.sdk.common.Trans;
import com.project.sdk.dto.feedBack.FeedBack;
import com.project.sdk.export.dto.feedBack.FeedBackDto;
import com.project.sdk.export.service.FeedBack.FeedBackExportService;
import com.project.sdk.service.FeedBackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liwanpeng on 2017/9/13.
 */
@Service("feedBackExportService")
public class FeedBackExportAdapter implements FeedBackExportService {
    @Resource
    private FeedBackService feedBackService;
    @Override
    public int addFeedBack(FeedBackDto param) {
        FeedBack feedBack = new FeedBack();
        feedBack   = (FeedBack) Trans.transBeanToBeanDto(feedBack,param);
        int i = feedBackService.addFeedBack(feedBack);
        return i;
    }
}
