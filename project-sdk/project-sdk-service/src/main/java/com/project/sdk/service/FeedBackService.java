package com.project.sdk.service;

import com.project.sdk.dto.feedBack.FeedBack;

/**
 * 帮助与反馈接口
 * Created by liwanpeng on 2017/9/13.
 */
public interface FeedBackService {
    /**
     * 添加帮助与 反馈
     * @param param
     * @return
     */
    int addFeedBack(FeedBack param);
}
