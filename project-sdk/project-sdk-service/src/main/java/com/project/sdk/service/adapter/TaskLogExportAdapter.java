package com.project.sdk.service.adapter;

import com.project.sdk.common.Trans;
import com.project.sdk.dto.taskLog.TaskLog;
import com.project.sdk.export.dto.taskLog.TaskLogDto;
import com.project.sdk.export.service.taskLog.TaskLogExportService;
import com.project.sdk.service.TaskLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liwanpeng on 2017/9/13.
 */
@Service("taskLogExportService")
public class TaskLogExportAdapter implements TaskLogExportService{
    @Resource
    private TaskLogService taskLogService;

    @Override
    public int addTaskLog(TaskLogDto param) {
        TaskLog taskLog =new TaskLog();
        taskLog=(TaskLog) Trans.transBeanToBeanDto(taskLog,param);
        int i = taskLogService.addTaskLog(taskLog);
        return i;
    }
}
