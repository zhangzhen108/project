package com.project.sdk.service;

import com.project.sdk.dto.food.Food;

import java.util.List;

/**
 * Created by zhangzhen on 2017/7/17.
 */
public interface FoodService {

    /*
    批量查询
     */
    public List<Food> queryList(Food record);

    /*
       删除
     */
    public int detete(int id);

    /*
        更新
     */
    public int update(Food record);
    /*
        增加
     */
    public int add(Food record);

}

