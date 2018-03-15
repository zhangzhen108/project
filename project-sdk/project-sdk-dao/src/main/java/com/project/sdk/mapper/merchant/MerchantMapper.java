package com.project.sdk.mapper.merchant;

import com.project.sdk.common.Pager;
import com.project.sdk.dto.merchant.Merchant;
import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
 * .
 * Created by zhangzhen on 2017/7/11.
 */
public interface MerchantMapper {


  public List<Merchant> queryList(@Param("record")Merchant merchantDto);

  /**
   * 根据id查询.
   * @param id id
   * @return Merchant
  */
  Merchant selectByPrimaryKey(Integer id);

  /**
   * 保存操作.
   * @param record record
   * @return int
  */
  int insertSelective(Merchant record);

  /**
   * 根据主键修改.
   * @param record record
   * @return int
  */
  int updateByPrimaryKeySelective(Merchant record);

  /**
   * 分页查询.
   * @param page page
   * @param merchant merchant
   * @return list
  */
  List<Merchant> findPageList(@Param("page") Pager page, @Param("record") Merchant merchant);

  /**
   * 查询条数.
   * @param merchant merchant
   * @return int
  */
  int queryCount(@Param("record") Merchant merchant);

  /**
   * 根据条件查询.
   * @param merchant merchant
   * @return list
  */
  List<Merchant> queryMerchantList(@Param("record") Merchant merchant);
}
