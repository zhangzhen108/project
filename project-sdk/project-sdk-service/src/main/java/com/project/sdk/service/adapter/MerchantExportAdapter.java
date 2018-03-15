package com.project.sdk.service.adapter;

import com.alibaba.fastjson.JSON;
import com.project.sdk.common.Pager;
import com.project.sdk.common.Trans;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.dto.merchant.Merchant;
import com.project.sdk.export.dto.merchant.MerchantExportDto;
import com.project.sdk.export.service.merchant.MerchantExportService;
import com.project.sdk.service.MerchantService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * .
 * Created by zhangzhen on 2017/7/11.
 */
@Service("merchantExportService")
public class MerchantExportAdapter implements MerchantExportService {
  @Resource
  MerchantService merchantService;

  @Override
  public ExecuteResult<List<MerchantExportDto>> queryMerchantList(MerchantExportDto merchantDto) {
    ExecuteResult<List<MerchantExportDto>> result = new ExecuteResult<List<MerchantExportDto>>();
    try {
      Merchant merchant = new Merchant();
      if (merchantDto == null) {
        merchantDto = new MerchantExportDto();
      }
      merchant = (Merchant) Trans.transBeanToBeanDto(merchantDto, merchant);
      List<Merchant> merchantList = this.merchantService.queryMerchantList(merchant);
      if (merchantList == null || merchantList.size() == 0) {
        return  result;
      }
      List<MerchantExportDto> list =
              (List) Trans.transListBeanToBeanDto(merchantList, new MerchantExportDto());
      result.setResult(list);
    } catch (Exception e) {
      result.setErrorMessage(JSON.toJSONString(e));
    }
    return result;
  }

  @Override
  public Pager<MerchantExportDto> queryPageList(Pager pager, MerchantExportDto merchantExportDto) {
    Pager<MerchantExportDto> result = new Pager<MerchantExportDto>();
    try {
      Merchant merchant = new Merchant();
      if (merchantExportDto == null) {
        merchantExportDto = new MerchantExportDto();
      }
      merchant = (Merchant) Trans.transBeanToBeanDto(merchantExportDto, merchant);
      Pager<Merchant> pagerResult = this.merchantService.queryPageList(pager,merchant);
      result = (Pager<MerchantExportDto>)Trans.transBeanToBeanDto(pagerResult,result);
      List<MerchantExportDto> list = new ArrayList<MerchantExportDto>();
      list = (List) Trans.transListBeanToBeanDto(result.getRecords(), new MerchantExportDto());
      result.setRecords(list);
    } catch (Exception e){
      String errorMsg = e.getMessage() == null ? "系统异常！" : e.getMessage();
      result.setErrorMessage(errorMsg);
    }
    return result;
  }

  @Override
  public ExecuteResult<MerchantExportDto> queryMerchantDtoById(Integer id) {
    ExecuteResult<MerchantExportDto> result = new ExecuteResult<MerchantExportDto>();
    try {
      Merchant merchant = this.merchantService.queryMerchantById(id);
      MerchantExportDto merchantExportDto = new MerchantExportDto();
      merchantExportDto = (MerchantExportDto)Trans.transBeanToBeanDto(merchant, merchantExportDto);
      result.setResult(merchantExportDto);
    } catch (Exception e){
      String errorMsg = e.getMessage() == null ? "系统异常！" : e.getMessage();
      result.setErrorMessage(errorMsg);
    }
    return result;
  }

  @Override
  public ExecuteResult<MerchantExportDto> addMerchantDto(MerchantExportDto merchantExportDto) {
    ExecuteResult<MerchantExportDto> result = new ExecuteResult<MerchantExportDto>();
    try {
      Merchant merchant = new Merchant();
      if (merchantExportDto == null) {
        result.setErrorMessage("参数为空！");
        return result;
      }
      merchant = (Merchant) Trans.transBeanToBeanDto(merchantExportDto, merchant);
      merchant = this.merchantService.saveMerchant(merchant);
      merchantExportDto = (MerchantExportDto)Trans.transBeanToBeanDto(merchant,merchantExportDto);
      result.setResult(merchantExportDto);
    } catch (Exception e){
      String errorMsg = e.getMessage() == null ? "系统异常！" : e.getMessage();
      result.setErrorMessage(errorMsg);
    }
    return result;
  }

  @Override
  public ExecuteResult<String> updateMerchantDtoById(MerchantExportDto merchantExportDto) {
    ExecuteResult<String> result = new ExecuteResult<String>();
    try {
      if (merchantExportDto == null) {
        result.setErrorMessage("参数为空！");
        return  result;
      }
      Merchant merchant = new Merchant();
      merchant = (Merchant) Trans.transBeanToBeanDto(merchantExportDto, merchant);
      this.merchantService.updateMerchantById(merchant);
    } catch (Exception e) {
      String errorMsg = e.getMessage() == null ? "系统异常！" : e.getMessage();
      result.setErrorMessage(errorMsg);
    }
    return result;
  }

  @Override
  public ExecuteResult<List<MerchantExportDto>> queryList(MerchantExportDto merchantDto) {
    ExecuteResult<List<MerchantExportDto>> result = new ExecuteResult<List<MerchantExportDto>>();
    try {
      Merchant merchant = new Merchant();
      if (merchantDto == null) {
        merchantDto = new MerchantExportDto();
      }
      merchant = (Merchant) Trans.transBeanToBeanDto(merchantDto, merchant);
      List<Merchant> merchantList = this.merchantService.queryList(merchant);
      if (merchantList == null || merchantList.size() == 0) {
        return  result;
      }
      List<MerchantExportDto> list =
              (List) Trans.transListBeanToBeanDto(merchantList, new MerchantExportDto());
      result.setResult(list);
    } catch (Exception e) {
      result.setErrorMessage(JSON.toJSONString(e));
    }
    return result;
  }
}
