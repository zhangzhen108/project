package com.project.sdk.service.impl;

import com.project.sdk.common.Pager;
import com.project.sdk.dto.merchant.Merchant;
import com.project.sdk.mapper.merchant.MerchantMapper;
import com.project.sdk.service.MerchantService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * .
 * Created by zhangzhen on 2017/7/11.
 */
@Service
public class MerchantServiceImpl implements MerchantService {
  @Resource
  private MerchantMapper merchantMapper;

  @Override
  public List<Merchant> queryMerchantList(Merchant merchant) {
    return this.merchantMapper.queryMerchantList(merchant);
  }

  @Transactional
  @Override
  public Merchant saveMerchant(Merchant merchant) {
    int count = this.merchantMapper.insertSelective(merchant);
    if (count <= 0) {
      throw new RuntimeException("商家信息保存失败");
    }
    return merchant;
  }

  @Override
  public Merchant queryMerchantById(Integer id) {
    return this.merchantMapper.selectByPrimaryKey(id);
  }

  @Transactional
  @Override
  public Boolean updateMerchantById(Merchant merchant) {
    int count = this.merchantMapper.updateByPrimaryKeySelective(merchant);
    if (count <= 0) {
      throw new RuntimeException("商家信息修改失败");
    }
    return true;
  }

  @Override
  public Pager<Merchant> queryPageList(Pager page, Merchant merchant) {
    Pager<Merchant> pager = new Pager<Merchant>();
    int count = this.merchantMapper.queryCount(merchant);
    List<Merchant> list = this.merchantMapper.findPageList(page,merchant);
    pager.setRecords(list);
    pager.setTotalCount(count);
    return pager;
  }

  @Override
  public List<Merchant> queryList(Merchant merchantDto) {
    return merchantMapper.queryList(merchantDto);
  }
}
