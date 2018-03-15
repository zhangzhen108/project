package com.project.sdk.service.impl;

import com.project.sdk.dto.feedBack.FeedBack;
import com.project.sdk.mapper.feedBack.FeedBackMapper;
import com.project.sdk.service.FeedBackService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by liwanpeng on 2017/9/13.
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Resource
    private FeedBackMapper feedBackMapper;

    @Transactional
    @Override
    public int addFeedBack(FeedBack param) {
            int insert = feedBackMapper.insert(param);
            return insert;
    }
}
