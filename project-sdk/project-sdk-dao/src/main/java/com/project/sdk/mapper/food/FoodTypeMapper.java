package com.project.sdk.mapper.food;

import com.project.sdk.dto.food.Food;
import com.project.sdk.dto.food.FoodType;

import java.util.List;

/**
 * Created by zhangzhen on 2017/8/7.
 */
public interface FoodTypeMapper {
    /*查询
    批量
     */
    public List<FoodType> queryList(FoodType foodType);

    public Integer insert(FoodType foodType);

    public Integer delete(int id);
}
