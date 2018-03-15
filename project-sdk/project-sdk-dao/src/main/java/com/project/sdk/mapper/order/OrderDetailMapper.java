package com.project.sdk.mapper.order;

import com.project.sdk.dto.order.OrderDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;



/**
 * OrderDetailMapper.
 * Created by sun on 2017/7/14.
 */
public interface OrderDetailMapper {
  /**
   * 添加订单详情菜单.
   *
   * @param orderDetail orderDetail
   * @return int
   */
  int addOrderDetail(OrderDetail orderDetail);

  /**
   * 添加list的订单详情.
   *
   * @param orderDetails orderDetails
   * @return int
   */
  int addOrderDetails(@Param("orderDetails") List<OrderDetail> orderDetails);

  /**
   * 根据订单id查询菜单详情.
   *
   * @param orderId orderId
   * @return List
   */
  List<OrderDetail> findListByOrderId(@Param("orderId") Long orderId);


  List<OrderDetail> getFoodSales(@Param("orderDetails")List<Integer> orderDetails );
}
