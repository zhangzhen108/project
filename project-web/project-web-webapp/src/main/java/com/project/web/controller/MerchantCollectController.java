package com.project.web.controller;

import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.merchant.MerchantCollectExportDto;
import com.project.sdk.export.dto.merchant.MerchantExportDto;
import com.project.sdk.export.service.merchant.MerchantConllectExportService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * .
 * Created by zhangzhen on 2017/7/11.
 */
@Controller
@RequestMapping("merchantCollect")
public class MerchantCollectController {

  @Resource
  private MerchantConllectExportService merchantConllectExportService;


  @ResponseBody
  @RequestMapping("/queryList")
  public String queryListMerchant(MerchantCollectExportDto merchantExportDto) {
    ExecuteResult<List<MerchantCollectExportDto>> result = new ExecuteResult<>();
    try {
      result = merchantConllectExportService.queryMerchantList(merchantExportDto);
    } catch (Exception e) {
      result.setErrorMessage(JSONObject.fromObject(e).toString());
    }
    return JSONObject.fromObject(result).toString();
  }

  @ResponseBody
  @RequestMapping("/addMerchantDto")
  public String addMerchantDto(MerchantCollectExportDto merchantExportDto) {
    ExecuteResult<MerchantCollectExportDto> result = new ExecuteResult<>();
    try {
      merchantExportDto.setCreateTime(new Date());
      merchantExportDto.setUpdateTime(new Date());
      result = merchantConllectExportService.addMerchantDto(merchantExportDto);
    } catch (Exception e) {
      result.setErrorMessage(JSONObject.fromObject(e).toString());
    }
    return JSONObject.fromObject(result).toString();
  }

  @ResponseBody
  @RequestMapping("/deleteMerchantCollect")
  public String deleteMerchantCollect(MerchantCollectExportDto merchantExportDto) {
    ExecuteResult<String> result = new ExecuteResult<>();
    try {
      merchantExportDto.setUpdateTime(new Date());
      merchantExportDto.setStatus("0");
      result = merchantConllectExportService.deleteMerchantCollect(merchantExportDto);
    } catch (Exception e) {
      result.setErrorMessage(JSONObject.fromObject(e).toString());
    }
    return JSONObject.fromObject(result).toString();
  }


}
