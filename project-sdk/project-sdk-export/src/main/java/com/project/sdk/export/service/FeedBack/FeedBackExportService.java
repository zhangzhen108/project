package com.project.sdk.export.service.FeedBack;

import com.project.sdk.export.dto.feedBack.FeedBackDto;

/**
 * 帮助与反馈暴露的接口
 * Created by liwanpeng on 2017/9/13.
 */
public interface FeedBackExportService {
    /**
     * 用户添加用户反馈
     * @param param
     * @return
     */
    int addFeedBack(FeedBackDto param);
}
