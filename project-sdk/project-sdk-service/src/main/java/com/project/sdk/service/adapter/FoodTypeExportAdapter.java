package com.project.sdk.service.adapter;

import com.alibaba.fastjson.JSON;
import com.project.sdk.common.Trans;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.dto.food.Food;
import com.project.sdk.dto.food.FoodType;
import com.project.sdk.export.dto.food.FoodDto;
import com.project.sdk.export.dto.food.FoodTypeDto;
import com.project.sdk.export.service.food.FoodTypeExportService;
import com.project.sdk.service.FoodTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */
@Service("foodTypeExportService")
public class FoodTypeExportAdapter implements FoodTypeExportService{


    @Resource
    FoodTypeService foodTypeService;

    @Override
    public ExecuteResult<List<FoodTypeDto>> queryList(FoodTypeDto foodTypeDto) {

        ExecuteResult<List<FoodTypeDto>> result = new ExecuteResult<List<FoodTypeDto>>();
        try {
            if(foodTypeDto==null){
                foodTypeDto=new FoodTypeDto();
            }
            FoodType foodType = new FoodType();
            foodType = (FoodType)Trans.transBeanToBeanDto(foodTypeDto,foodType);
            List<FoodType> foodTypeList=foodTypeService.queryList(foodType);
            List<FoodTypeDto> list = (List)Trans.transListBeanToBeanDto(foodTypeList,new FoodTypeDto());
            result.setResult(list);
        } catch (Exception e) {
            result.setErrorMessage(JSON.toJSONString(e));
        }
        return result;
    }

    @Override
    public ExecuteResult<Integer> insert(FoodTypeDto foodTypeDto) {
        ExecuteResult<Integer> result = new ExecuteResult<Integer>();
        try {
            if(foodTypeDto==null){
                foodTypeDto=new FoodTypeDto();
            }
            FoodType foodType = new FoodType();
            foodType = (FoodType)Trans.transBeanToBeanDto(foodTypeDto,foodType);
            Integer insert=foodTypeService.insert(foodType);
            result.setResult(insert);
        } catch (Exception e) {
            result.setErrorMessage(JSON.toJSONString(e));
        }
        return result;
    }

    @Override
    public ExecuteResult<Integer> delete(int id) {
        ExecuteResult<Integer> result = new ExecuteResult<Integer>();
        try {
            if(id==0){
                result.setErrorMessage("id不能为空");
                return result;
            }
            Integer insert=foodTypeService.delete(id);
            result.setResult(insert);
        } catch (Exception e) {
            result.setErrorMessage(JSON.toJSONString(e));
        }
        return result;
    }
}
