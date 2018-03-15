package com.project.sdk.service.impl;

import com.project.sdk.dto.taskLog.TaskLog;
import com.project.sdk.mapper.taskLog.TaskLogMapper;
import com.project.sdk.service.TaskLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liwanpeng on 2017/9/13.
 */
@Service
public class TaskLogServiceImp implements TaskLogService {
    @Resource
    private TaskLogMapper taskLogMapper;
    @Override
    public int addTaskLog(TaskLog taskLog) {
        int insert = taskLogMapper.insert(taskLog);
        return insert;
    }
}
