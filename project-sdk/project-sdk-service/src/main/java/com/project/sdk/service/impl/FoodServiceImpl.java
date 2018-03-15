package com.project.sdk.service.impl;

import com.project.sdk.dto.food.Food;
import com.project.sdk.mapper.food.FoodMapper;
import com.project.sdk.service.FoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangzhen on 2017/7/17.
 */
@Service
public class FoodServiceImpl implements FoodService{
    @Resource
    FoodMapper foodMapper;
    @Override
    public List<Food> queryList(Food record) {
        return foodMapper.queryList(record);
    }

    @Override
    public int detete(int id) {
        return foodMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Food record) {
        return foodMapper.updateByPrimaryKey(record);
    }

    @Override
    public int add(Food record) {
        return foodMapper.insert(record);
    }
}
