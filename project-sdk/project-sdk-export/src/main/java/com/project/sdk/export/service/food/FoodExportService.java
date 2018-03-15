package com.project.sdk.export.service.food;

import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.food.FoodDto;

import java.util.List;

/**
 * Created by zhangzhen on 2017/7/17.
 */
public interface FoodExportService {

    /*
   批量查询
    */
    public ExecuteResult<List<FoodDto>> queryList(FoodDto record);

    /*
       删除
     */
    public ExecuteResult<Integer> detete(int id);

    /*
        更新
     */
    public ExecuteResult<Integer> update(FoodDto record);
    /*
        增加
     */
    public ExecuteResult<Integer> add(FoodDto record);
}
