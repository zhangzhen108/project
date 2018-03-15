package com.project.web.service.impl;

import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.food.FoodDto;
import com.project.sdk.export.service.food.FoodExportService;
import com.project.web.service.FoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangzhen on 2017/9/4.
 */
@Service
public class FoodServiceImpl implements FoodService{

    @Resource
    FoodExportService foodExportService;

    @Override
    public ExecuteResult<Integer> insert(FoodDto foodDto) {
        ExecuteResult<Integer> result=foodExportService.add(foodDto);
        if("0".equals(result.getResult())){
        result.setErrorMessage("插入失败");
        }
        return result;
    }

    @Override
    public ExecuteResult<Integer> delete(int id) {
        ExecuteResult<Integer> result=foodExportService.detete(id);
        if("0".equals(result.getResult())){
            result.setErrorMessage("删除失败");
        }
        return result;
    }

    @Override
    public ExecuteResult<List<FoodDto>> queryList(FoodDto foodDto) {
        ExecuteResult<List<FoodDto>> result=foodExportService.queryList(foodDto);
        return result;
    }
}
