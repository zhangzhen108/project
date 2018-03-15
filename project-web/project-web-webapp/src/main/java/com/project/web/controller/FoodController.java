package com.project.web.controller;


import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.food.FoodDto;
import com.project.sdk.export.service.food.FoodExportService;
import com.project.sdk.export.service.food.FoodTypeExportService;
import com.project.web.service.FoodService;
import com.project.web.service.FoodTypeService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangzhen on 2017/7/17.
 */
@Controller
@RequestMapping("project/food")
public class FoodController {
    @Resource
    FoodService foodService;
    @RequestMapping("queryList")
    @ResponseBody
    public String queryList(FoodDto foodDto){
        ExecuteResult<List<FoodDto>> result=new ExecuteResult<List<FoodDto>>();
        try{
            result= foodService.queryList(foodDto);
        }catch (Exception e){
            System.out.print(e.toString());
            result.setErrorMessage(JSONObject.fromObject(e).toString());
        }
        return JSONObject.fromObject(result).toString();
    }
    @RequestMapping("delete")
    @ResponseBody
    public String delete(int id){
        ExecuteResult<Integer> result=new ExecuteResult<Integer>();
        try{
            result= foodService.delete(id);
        }catch (Exception e){
            System.out.print(e.toString());
            result.setErrorMessage(JSONObject.fromObject(e).toString());
        }
        return JSONObject.fromObject(result).toString();
    }
    @RequestMapping("insert")
    @ResponseBody
    public String insert(FoodDto foodDto){
        ExecuteResult<Integer> result=new ExecuteResult<Integer>();
        try{
            result= foodService.insert(foodDto);
        }catch (Exception e){
            System.out.print(e.toString());
            result.setErrorMessage(JSONObject.fromObject(e).toString());
        }
        return JSONObject.fromObject(result).toString();
    }
}
