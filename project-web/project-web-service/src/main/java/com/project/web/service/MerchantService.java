package com.project.web.service;

import com.project.sdk.common.Pager;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.merchant.MerchantExportDto;

import java.util.List;

/**商家类
 * Created by zhangzhen on 2017/7/11.
 */
public interface MerchantService {
    

  ExecuteResult<List<MerchantExportDto>> queryList(MerchantExportDto merchantExportDto);
  /**
     * 分页查询方法.
     * @param pager pager
     * @param merchantExportDto merchantExportDto
     * @return
     * Created by liq
  */

  Pager<MerchantExportDto> queryPagerList(Pager pager,MerchantExportDto merchantExportDto);

}
