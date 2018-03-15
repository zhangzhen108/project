package com.project.sdk.service;

import com.project.sdk.dto.taskLog.TaskLog;

/**
 * 定时任务接口
 * Created by liwanpeng on 2017/9/13.
 */
public interface TaskLogService {
    /**
     * 添加定时任务日志
     * @param taskLog
     * @return
     */
    int addTaskLog(TaskLog taskLog);
}
