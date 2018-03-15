package com.project.sdk.mapper.order;

import com.project.sdk.dto.order.ZmMerchantCollect;
import com.project.sdk.dto.order.ZmMerchantCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantCollectMapper {
    int countByExample(ZmMerchantCollectExample example);

    int deleteByExample(ZmMerchantCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZmMerchantCollect record);

    int insertSelective(ZmMerchantCollect record);

    List<ZmMerchantCollect> selectByExample(ZmMerchantCollectExample example);

    ZmMerchantCollect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZmMerchantCollect record, @Param("example") ZmMerchantCollectExample example);

    int updateByExample(@Param("record") ZmMerchantCollect record, @Param("example") ZmMerchantCollectExample example);

    int updateByPrimaryKeySelective(ZmMerchantCollect record);

    int updateByPrimaryKey(ZmMerchantCollect record);
}