package com.project.sdk.mapper.merchant;

import java.util.List;

import com.project.sdk.dto.merchant.MerchantCollect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantCollectMapper {

  /**
   * merchantCollect.
   *
   * @param merchantCollect merchantCollect
   * @return MerchantCollect
   */
  int addMerchantCollect(MerchantCollect merchantCollect);

  /**
   * 修改merchantCollect.
   *
   * @param merchantCollect merchantCollect
   * @return int
   */
  int deleteMerchantCollect(@Param("entity") MerchantCollect merchantCollect);

  /**
   * 查询merchantCollect列表.
   *
   * @return List
   */
  List<MerchantCollect> findMerchantCollects(@Param("entity") MerchantCollect merchantCollect);

}