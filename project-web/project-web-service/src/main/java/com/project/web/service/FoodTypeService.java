package com.project.web.service;

import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.food.FoodDto;
import com.project.sdk.export.dto.food.FoodTypeDto;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhen on 2017/7/17.
 */
public interface FoodTypeService {


    public Map<String, Object> queryList(FoodTypeDto foodTypeDto);

    public  ExecuteResult<Integer>  insert(FoodTypeDto foodTypeDto);

    public  ExecuteResult<Integer>  delete(int  id);
}
