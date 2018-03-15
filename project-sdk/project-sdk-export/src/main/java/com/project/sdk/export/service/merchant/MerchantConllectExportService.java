package com.project.sdk.export.service.merchant;

import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.merchant.MerchantCollectExportDto;

import java.util.List;

/**
 * .
 * Created by zhangzhen on 2017/7/11.
 */
public interface MerchantConllectExportService {

  /**
     * 保存操作.
     * @param merchantExportDto merchantExportDto
     * @return dto
  */
  ExecuteResult<MerchantCollectExportDto> addMerchantDto(MerchantCollectExportDto merchantExportDto);

  /**
     * 根据主键修改商家信息.
     * @param merchantExportDto merchantExportDto
     * @return ExecuteResult
  */
  ExecuteResult<String> deleteMerchantCollect(MerchantCollectExportDto merchantExportDto);

  /**
     * 条件查询.
     * @param merchantDto merchantDto
     * @return list
  */
  ExecuteResult<List<MerchantCollectExportDto>> queryMerchantList(MerchantCollectExportDto merchantDto);
}
