package com.project.sdk.service.impl;

import com.project.sdk.common.Pager;
import com.project.sdk.dto.merchant.Merchant;
import com.project.sdk.dto.merchant.MerchantCollect;
import com.project.sdk.mapper.merchant.MerchantCollectMapper;
import com.project.sdk.mapper.merchant.MerchantMapper;
import com.project.sdk.service.MerchantConllectService;
import com.project.sdk.service.MerchantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * .
 * Created by zhangzhen on 2017/7/11.
 */
@Service
public class MerchantConllectServiceImpl implements MerchantConllectService {
  @Resource
  private MerchantCollectMapper merchantCollectMapper;

  @Override
  public int addMerchantCollect(MerchantCollect merchant) {
    return merchantCollectMapper.addMerchantCollect(merchant);
  }

  @Override
  public Boolean deleteMerchantCollect(MerchantCollect merchant) {
    merchant.setStatus("0");
    int i = merchantCollectMapper.deleteMerchantCollect(merchant);
    if (i > 0) {
      return true;
    }
    return false;
  }

  @Override
  public List<MerchantCollect> findMerchantCollects(MerchantCollect merchant) {
    return merchantCollectMapper.findMerchantCollects(merchant);
  }
}
