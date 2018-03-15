package com.project.sdk.service;

import com.project.sdk.common.Pager;
import com.project.sdk.dto.merchant.Merchant;

import java.util.List;

/**
 * .
 * Created by zhangzhen on 2017/7/11.
 */
public interface MerchantService {

  List<Merchant> queryList(Merchant merchantDto);

  /**
     * 保存商家信息.
     * @param merchant merchant
     * @return merchant
  */

  Merchant saveMerchant(Merchant merchant);

  /**
     * 根据id查询商家信息.
     * @param id id
     * @return Merchant
  */

  Merchant queryMerchantById(Integer id);

  /**
     * 根据主键修改商家信息.
     * @param merchant merchant
     * @return Boolean
  */

  Boolean updateMerchantById(Merchant merchant);

  /**
     * 分页查询商家信息.
     * @param page page
     * @param merchant merchant
     * @return
     * Created by liq
  */

  Pager<Merchant> queryPageList(Pager page,Merchant merchant);

  /**
     * 条件查询.
     * @param merchant merchant
     * @return list
   *
  */

  List<Merchant> queryMerchantList(Merchant merchant);
}
