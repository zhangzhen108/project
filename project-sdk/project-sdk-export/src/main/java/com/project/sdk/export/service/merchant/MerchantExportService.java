package com.project.sdk.export.service.merchant;

import com.project.sdk.common.Pager;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.merchant.MerchantExportDto;

import java.util.List;

/**
 * .
 * Created by zhangzhen on 2017/7/11.
 */
public interface MerchantExportService {

  ExecuteResult<List<MerchantExportDto>> queryList(MerchantExportDto merchantDto);

  /**
   * 分页查询.
   * @param pager pager
   * @param merchantExportDto merchantExportDto
   * @return page
  */
  Pager<MerchantExportDto> queryPageList(Pager pager,MerchantExportDto merchantExportDto);

  /**
     * 根据id查询数据.
     * @param id id
     * @return dto
  */
  ExecuteResult<MerchantExportDto> queryMerchantDtoById(Integer id);

  /**
     * 保存操作.
     * @param merchantExportDto merchantExportDto
     * @return dto
  */
  ExecuteResult<MerchantExportDto> addMerchantDto(MerchantExportDto merchantExportDto);

  /**
     * 根据主键修改商家信息.
     * @param merchantExportDto merchantExportDto
     * @return ExecuteResult
  */
  ExecuteResult<String> updateMerchantDtoById(MerchantExportDto merchantExportDto);

  /**
     * 条件查询.
     * @param merchantDto merchantDto
     * @return list
  */
  ExecuteResult<List<MerchantExportDto>> queryMerchantList(MerchantExportDto merchantDto);
}
