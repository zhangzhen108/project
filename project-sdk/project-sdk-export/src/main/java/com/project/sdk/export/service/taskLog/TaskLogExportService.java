package com.project.sdk.export.service.taskLog;

import com.project.sdk.export.dto.taskLog.TaskLogDto;

/**
 * 定时任务日志接口
 * Created by liwanpeng on 2017/9/13.
 */
public interface TaskLogExportService {
    /**
     * 添加定时任务日志
     * @param param
     * @return
     */
    int addTaskLog(TaskLogDto param);
}
