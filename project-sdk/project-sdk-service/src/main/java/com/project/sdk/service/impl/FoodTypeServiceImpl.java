package com.project.sdk.service.impl;

import com.project.sdk.dto.food.Food;
import com.project.sdk.dto.food.FoodType;
import com.project.sdk.mapper.food.FoodTypeMapper;
import com.project.sdk.service.FoodTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */
@Service()
public class FoodTypeServiceImpl implements FoodTypeService {
    @Resource
    FoodTypeMapper foodTypeMapper;
    @Override
    public List<FoodType> queryList(FoodType foodtype) {
        return foodTypeMapper.queryList(foodtype);
    }

    @Override
    public Integer insert(FoodType foodType) {
        return foodTypeMapper.insert(foodType);
    }

    @Override
    public Integer delete(int id) {
        return foodTypeMapper.delete(id);
    }
}
