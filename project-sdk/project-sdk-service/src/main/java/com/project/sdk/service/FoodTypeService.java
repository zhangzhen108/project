package com.project.sdk.service;

import com.project.sdk.dto.food.Food;
import com.project.sdk.dto.food.FoodType;

import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */
public interface FoodTypeService {


    public List<FoodType> queryList(FoodType foodType);

    public Integer insert(FoodType foodType);

    public Integer delete(int id);
}
