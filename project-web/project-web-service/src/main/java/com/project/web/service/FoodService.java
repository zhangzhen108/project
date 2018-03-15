package com.project.web.service;

import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.food.FoodDto;
import com.project.sdk.export.dto.food.FoodTypeDto;

import java.util.List;

/**
 * Created by zhangzhen on 2017/9/4.
 */
public interface FoodService {

    public ExecuteResult<Integer> insert(FoodDto foodDto);

    public  ExecuteResult<Integer>  delete(int  id);

    public  ExecuteResult<List<FoodDto>>  queryList(FoodDto foodDto);
}
