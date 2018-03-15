package com.project.sdk.service.adapter;

import com.alibaba.fastjson.JSON;
import com.project.sdk.common.Trans;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.dto.food.Food;
import com.project.sdk.export.dto.food.FoodDto;
import com.project.sdk.export.service.food.FoodExportService;
import com.project.sdk.service.FoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangzhen on 2017/7/17.
 */
@Service("foodExportService")
public class FoodExportAdapter implements FoodExportService {
  @Resource
  FoodService foodService;

  @Override
  public ExecuteResult<List<FoodDto>> queryList(FoodDto record) {
    ExecuteResult<List<FoodDto>> result = new ExecuteResult<List<FoodDto>>();
    try {
        if(record==null){
            record=new FoodDto();
        }
        Food food = new Food();
        food = (Food) Trans.transBeanToBeanDto(record, food);
        List<FoodDto> list = (List) Trans.transListBeanToBeanDto(foodService.queryList(food), new FoodDto());
            result.setResult(list);
        } catch (Exception e) {
            result.setErrorMessage(e.getMessage());
        }
        return result;
    }

    @Override
    public ExecuteResult<Integer> detete(int id) {
        ExecuteResult<Integer> result = new ExecuteResult<Integer>();
        try {
            int num = foodService.detete(id);
            result.setResult(num);
        } catch (Exception e) {
            result.setErrorMessage(JSON.toJSONString(e));
        }
        return result;
    }

    @Override
    public ExecuteResult<Integer> update(FoodDto record) {
        ExecuteResult<Integer> result = new ExecuteResult<Integer>();
        try {
            Food food = new Food();
            food = (Food) Trans.transBeanToBeanDto(record, food);
            int num = foodService.update(food);
            result.setResult(num);
        } catch (Exception e) {
            result.setErrorMessage(JSON.toJSONString(e));
        }
        return result;
    }

    @Override
    public ExecuteResult<Integer> add(FoodDto record) {
        ExecuteResult<Integer> result = new ExecuteResult<Integer>();
        try {
            Food food = new Food();
            food = (Food) Trans.transBeanToBeanDto(record, food);
            int num = foodService.add(food);
            result.setResult(num);
        } catch (Exception e) {
            result.setErrorMessage(JSON.toJSONString(e));
        }
        return result;
    }
}
