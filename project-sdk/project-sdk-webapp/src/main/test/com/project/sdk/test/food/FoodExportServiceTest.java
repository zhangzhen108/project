package com.project.sdk.test.food;

import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.food.FoodDto;
import com.project.sdk.export.dto.food.FoodTypeDto;
import com.project.sdk.export.service.food.FoodExportService;
import com.project.sdk.export.service.food.FoodTypeExportService;
import com.project.sdk.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangzhen on 2017/8/17.
 */
public class FoodExportServiceTest extends BaseTest {

    @Resource
    FoodExportService foodExportService;
    @Resource
    FoodTypeExportService foodTypeExportService;
    @Test
    public void queryList(){
        ExecuteResult<List<FoodTypeDto>> result1=foodTypeExportService.queryList(null);
        ExecuteResult<List<FoodDto>> result=foodExportService.queryList(null);
        System.out.print(result);
        System.out.print(result1);
    }
}
