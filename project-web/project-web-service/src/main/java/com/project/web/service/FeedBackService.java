package com.project.web.service;

import com.project.sdk.export.dto.feedBack.FeedBackDto;

/**
 * 用户反馈
 * Created by liwanpeng on 2017/9/13.
 */
public interface FeedBackService {
    /**
     * 添加用户反馈
     * @param param
     * @return
     */
    int addFeedBack(FeedBackDto param) ;
}
