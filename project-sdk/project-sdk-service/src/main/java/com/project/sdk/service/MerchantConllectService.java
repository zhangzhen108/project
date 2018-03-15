package com.project.sdk.service;


import com.project.sdk.dto.merchant.MerchantCollect;

import java.util.List;

public interface MerchantConllectService {

  /**
     * 保存收藏信息.
     * @param merchant merchant
     * @return merchant
  */

  int addMerchantCollect(MerchantCollect merchant);

  /**
     * 删除收藏信息.
     * @param merchant merchant
     * @return Boolean
  */

  Boolean deleteMerchantCollect(MerchantCollect merchant);


  /**
     * 条件查询.
     * @param merchant merchant
     * @return list
   *
  */

  List<MerchantCollect> findMerchantCollects(MerchantCollect merchant);
}
