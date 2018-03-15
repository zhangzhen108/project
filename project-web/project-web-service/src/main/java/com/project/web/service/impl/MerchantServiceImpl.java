package com.project.web.service.impl;

import com.project.sdk.common.Pager;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.merchant.MerchantExportDto;
import com.project.sdk.export.service.merchant.MerchantExportService;
import com.project.web.service.MerchantService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * .
 * Created by zhangzhen on 2017/7/11.
 */
@Service
public class MerchantServiceImpl implements MerchantService {
  @Resource
  MerchantExportService merchantExportService;

  @Override
  public ExecuteResult<List<MerchantExportDto>> queryList(MerchantExportDto merchantExportDto) {
    ExecuteResult<List<MerchantExportDto>> ressult = new ExecuteResult<List<MerchantExportDto>>();
    ressult = merchantExportService.queryList(merchantExportDto);
    return ressult;
  }

  @Override
  public Pager<MerchantExportDto> queryPagerList(Pager pager, MerchantExportDto merchantExportDto) {
    Pager<MerchantExportDto> result = new Pager<>();
    try {
      result = this.merchantExportService.queryPageList(pager,merchantExportDto);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }
}
