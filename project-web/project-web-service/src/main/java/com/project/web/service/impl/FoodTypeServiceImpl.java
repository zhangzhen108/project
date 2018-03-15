package com.project.web.service.impl;

import com.alibaba.dubbo.common.json.JSON;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.food.FoodDto;
import com.project.sdk.export.dto.food.FoodTypeDto;
import com.project.sdk.export.dto.merchant.MerchantExportDto;
import com.project.sdk.export.service.food.FoodExportService;
import com.project.sdk.export.service.food.FoodTypeExportService;
import com.project.sdk.export.service.merchant.MerchantExportService;
import com.project.sdk.export.service.order.OrderExportService;
import com.project.web.service.FoodTypeService;
import com.project.web.service.MerchantService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhen on 2017/7/17.
 */
@Service
public class FoodTypeServiceImpl implements FoodTypeService {
  @Resource
  FoodTypeExportService foodTypeExportService;
  @Resource
  FoodExportService foodExportService;
  @Resource
  MerchantService merchantService;
  @Override
  public Map<String, Object> queryList(FoodTypeDto foodTypeDto) {
    ExecuteResult<List<FoodTypeDto>> foodTypeResult=new ExecuteResult<List<FoodTypeDto>>();
    ExecuteResult<List<FoodDto>> foodDtoResult=new ExecuteResult<List<FoodDto>>();
    Map<String, Object> resultMap=new HashMap<>();
      /*
      查询所有类型
       */
      foodTypeResult=foodTypeExportService.queryList(foodTypeDto);
    if(!foodTypeResult.isSuccess()){
      throw  new RuntimeException("查询食品类型失败");
    }
      List<FoodTypeDto> foodTypeList=foodTypeResult.getResult();
      /*
      获取所有类型
       */
      List<String> foodTypes=new ArrayList<String>();
      for (int i = 0; i < foodTypeList.size(); i++) {
        foodTypes.add(foodTypeList.get(i).getId().toString());
      }
      /*
      获取所有食品类型  根据食品类型查询食品
       */
      FoodDto foodDto=new FoodDto();
      foodDto.setFoodTypeIdList(foodTypes);
      foodDtoResult=foodExportService.queryList(foodDto);
    if(!foodDtoResult.isSuccess()){
      throw new RuntimeException("查询食品信息失败");

    }
      List<FoodDto> foodDtos=foodDtoResult.getResult();
    //食品月售查询

      /*
      将食品按照类型分组
       */
      Map<String,List<FoodDto>> foodDtoMap=new HashMap<>();
      for (int i = 0; i <foodDtos.size(); i++) {
        FoodDto food=foodDtos.get(i);
        if(foodDtoMap.containsKey(food.getFoodtypeid().toString())){
          foodDtoMap.get(food.getFoodtypeid().toString()).add(food);
        }else{
          List<FoodDto> list=new ArrayList<>();
          list.add(food);
          foodDtoMap.put(food.getFoodtypeid().toString(),list);
        }
      }
      /*
      循环foodType绑定数据food
       */
      for (int i = 0; i <foodTypeList.size(); i++) {
        FoodTypeDto foodTypeDto1=foodTypeList.get(i);
        foodTypeDto1.setFoodList(foodDtoMap.get(foodTypeDto1.getId().toString()));
      }
      resultMap.put("foodAndType",foodTypeList);
    /*
    查询商家信息
     */
    MerchantExportDto merchantExportDto=new MerchantExportDto();
    merchantExportDto.setId(Integer.decode(foodTypeDto.getMerchantid()));
    ExecuteResult<List<MerchantExportDto>> merchantResult=merchantService.queryList(merchantExportDto);
    if(!merchantResult.isSuccess()){
      throw new RuntimeException("查询商家信息失败");
    }
    resultMap.put("merchant",merchantResult.getResult().get(0));
    return resultMap;
  }

  @Override
  public ExecuteResult<Integer> insert(FoodTypeDto foodTypeDto) {
    ExecuteResult<Integer> result=foodTypeExportService.insert(foodTypeDto);
    if("0".equals(result.getResult())){
      result.setErrorMessage("插入失败");
    }
    return result;
  }

  @Override
  public ExecuteResult<Integer> delete(int id) {
    ExecuteResult<Integer> result=foodTypeExportService.delete(id);
    if("0".equals(result.getResult())){
      result.setErrorMessage("删除失败");
    }
    return result;
  }

}
