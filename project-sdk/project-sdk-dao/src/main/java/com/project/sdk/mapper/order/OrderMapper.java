package com.project.sdk.mapper.order;

import com.project.sdk.common.Pager;
import com.project.sdk.dto.order.OrderDto;

import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * OrderMapper.
 * Created by sun on 2017/7/12.
 */
public interface OrderMapper {
  /**
   * 新增order.
   *
   * @param orderDto orderDto
   * @return OrderDto
   */
  int addOrder(OrderDto orderDto);

  /**
   * 修改order.
   *
   * @param orderDto orderDto
   * @return int
   */
  int updateOrder(@Param("entity") OrderDto orderDto);

  /**
   * 查询order列表.
   *
   * @return List
   */
  List<OrderDto> findOrders(@Param("page") Pager page, @Param("entity") OrderDto orderDto);

  /**
   * 根据id获取order.
   *
   * @param id id
   * @return OrderDto
   */
  OrderDto queryById(@Param("id") Long id);

  /**
   * <p>Discription:[查询数量]</p>.
   * Created on
   *
   * @param orderDto 对象
   * @return 返回总数
   * @author:sun
   */
  int queryCount(@Param("entity") OrderDto orderDto);

  /**
   * 通过merChantId和状态标示获取订单销量.
   * @param merchantId merchantId 店铺id
   * @param status status 状态列表
   * @return Integer 订单数量
   */
  Integer getSalesByMerchantId(@Param("merchantId") Long merchantId,
                               @Param("status") List<String> status);

  /**
   * 根据订单号获取订单信息.
   * @param number number
   * @return OrderDto
   */
  OrderDto getOrderByNumer(@Param("number")String number);
}
