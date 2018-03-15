package com.project.web.controller;

import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.food.FoodTypeDto;
import com.project.sdk.export.service.food.FoodTypeExportService;
import com.project.web.service.FoodTypeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/5.
 */
@Controller
@RequestMapping("project/foodType")
public class FoodTypeController {

    @Resource
    FoodTypeService foodTypeService;
    @RequestMapping("queryList")
    @ResponseBody
    public String queryList(FoodTypeDto foodTypeDto){
        ExecuteResult<Map<String,Object>> result=new ExecuteResult<Map<String,Object>>();
        try{
            Map<String,Object> map= foodTypeService.queryList(foodTypeDto);
            result.setResult(map);
        }catch (Exception e){
            System.out.print(e.toString());
            result.setErrorMessage(JSONObject.fromObject(e).toString());
        }
        return JSONObject.fromObject(result).toString();
    }
    @RequestMapping("insert")
    @ResponseBody
    public String insert(FoodTypeDto foodTypeDto){
        ExecuteResult<Integer> result=new ExecuteResult<Integer>();
        try{
            result= foodTypeService.insert(foodTypeDto);
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
            result= foodTypeService.delete(id);
        }catch (Exception e){
            System.out.print(e.toString());
            result.setErrorMessage(JSONObject.fromObject(e).toString());
        }
        return JSONObject.fromObject(result).toString();
    }
}
