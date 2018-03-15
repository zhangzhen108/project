package com.project.sdk.export.service.food;


import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.food.FoodDto;
import com.project.sdk.export.dto.food.FoodTypeDto;

import java.util.List;

/**食品类型
 * Created by zhangzhen on 2017/8/5.
 */
public interface FoodTypeExportService {
    /*
    批量查询
     */
    public ExecuteResult<List<FoodTypeDto>> queryList(FoodTypeDto foodTypeDto);

    public ExecuteResult<Integer> insert(FoodTypeDto foodTypeDto);

    public ExecuteResult<Integer> delete(int id);
}
