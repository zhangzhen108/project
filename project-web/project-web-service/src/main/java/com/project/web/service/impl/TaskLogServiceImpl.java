package com.project.web.service.impl;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.export.dto.taskLog.TaskLogDto;
import com.project.sdk.export.service.taskLog.TaskLogExportService;
import com.project.web.service.TaskLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.rmi.server.ExportException;

/**
 * Created by liwanpeng on 2017/9/13.
 */
@Service
public class TaskLogServiceImpl implements TaskLogService {
    @Resource
    private TaskLogExportService taskLogExportService;
    @Override
    public ExecuteResult<Integer> addTaskLog(TaskLogDto param) {
        ExecuteResult<Integer> result = new ExecuteResult<Integer>();
        try {
            int i = taskLogExportService.addTaskLog(param);
            result.setResultMsg("添加成功！");
            result.setResult(i);
            result.setSuccess(true);
            return result;
        }catch (Exception e)
        {
         e.printStackTrace();
         result.setErrorMessage("添加定时任务日志失败！");
         return result;
        }
    }
}
