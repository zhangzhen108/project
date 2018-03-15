package com.project.web.controller;

import com.project.sdk.common.ExecuteResult;
import com.project.sdk.export.dto.taskLog.TaskLogDto;
import com.project.web.service.TaskLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by liwanpeng on 2017/9/13.
 */
@Controller
@RequestMapping("/project/taskLog")
public class TaskLogController {
    @Resource
    private TaskLogService taskLogService;
    @RequestMapping("addTaskLog")
    @ResponseBody
    public ExecuteResult<Integer> addTaskLog(TaskLogDto param)
    {
        ExecuteResult<Integer> result = new ExecuteResult<Integer>();
        result = taskLogService.addTaskLog(param);
        return result;
    }
}
