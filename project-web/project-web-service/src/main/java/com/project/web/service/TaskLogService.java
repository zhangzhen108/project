package com.project.web.service;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.export.dto.taskLog.TaskLogDto;

/**
 *定时任务日志
 * Created by liwanpeng on 2017/9/13.
 */
public interface TaskLogService {
    /**
     * 添加定时任务日志
     * @param param
     * @return
     */
    ExecuteResult<Integer> addTaskLog(TaskLogDto param);
}
