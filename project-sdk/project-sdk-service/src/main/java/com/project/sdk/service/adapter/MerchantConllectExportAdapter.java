package com.project.sdk.service.adapter;

import com.alibaba.fastjson.JSON;
import com.project.sdk.common.Trans;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.dto.merchant.MerchantCollect;
import com.project.sdk.export.dto.merchant.MerchantCollectExportDto;
import com.project.sdk.export.service.merchant.MerchantConllectExportService;
import com.project.sdk.service.MerchantConllectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("merchantConllectExportService")
public class MerchantConllectExportAdapter implements MerchantConllectExportService {
  @Resource
  private MerchantConllectService merchantConllectService;


  @Override
  public ExecuteResult<MerchantCollectExportDto> addMerchantDto(MerchantCollectExportDto merchantExportDto) {
    ExecuteResult<MerchantCollectExportDto> result = new ExecuteResult<>();
    try {
      MerchantCollect merchantCollect = new MerchantCollect();
      merchantCollect = (MerchantCollect) Trans.transBeanToBeanDto(merchantExportDto, merchantCollect);
      int i = merchantConllectService.addMerchantCollect(merchantCollect);
      if (i <= 0) {
        result.setErrorMessage("保存失败");
      }
    } catch (Exception e) {
      result.setErrorMessage(JSON.toJSONString(e));
    }
    return result;
  }

  @Override
  public ExecuteResult<String> deleteMerchantCollect(MerchantCollectExportDto merchantExportDto) {
    ExecuteResult<String> result = new ExecuteResult<>();
    try {
      MerchantCollect merchantCollect = new MerchantCollect();
      merchantCollect = (MerchantCollect) Trans.transBeanToBeanDto(merchantExportDto, merchantCollect);
      boolean i = merchantConllectService.deleteMerchantCollect(merchantCollect);
      if (i) {
        result.setErrorMessage("删除失败");
      }
    } catch (Exception e) {
      result.setErrorMessage(JSON.toJSONString(e));
    }
    return result;
  }

  @Override
  public ExecuteResult<List<MerchantCollectExportDto>> queryMerchantList(MerchantCollectExportDto merchantDto) {
    ExecuteResult<List<MerchantCollectExportDto>> result = new ExecuteResult<>();
    try {
      MerchantCollect merchantCollect = new MerchantCollect();
      merchantCollect = (MerchantCollect) Trans.transBeanToBeanDto(merchantDto, merchantCollect);
      List<MerchantCollect> list = merchantConllectService.findMerchantCollects(merchantCollect);
      List<MerchantCollectExportDto> resultList = (List) Trans.transListBeanToBeanDto(list, new MerchantCollectExportDto());
      result.setResult(resultList);
    } catch (Exception e) {
      result.setErrorMessage(JSON.toJSONString(e));
    }
    return result;
  }
}
