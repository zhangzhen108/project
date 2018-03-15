package com.project.sdk.service;

import com.project.sdk.common.Pager;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.dto.order.OrderDetail;
import com.project.sdk.dto.order.OrderDto;
import com.project.sdk.dto.order.OrderSubScribe;
import com.project.sdk.export.dto.order.OrderExportDto;

import java.util.List;

/**
 * OrderService.
 * Created by sun on 2017/7/12.
 */
public interface OrderService {

  /**
   * 添加订单信息.
   *
   * @param orderDto orderDto
   * @return OrderDto.id
   */
  public OrderDto addOrderInfo(OrderDto orderDto,List<OrderDetail> list);

  /**
   * 添加订单详情.
   *
   * @param orderDetail orderDetail
   * @return OrderDetail
   */
  public int addOrderDetail(OrderDetail orderDetail);

  /**
   * 批量添加订单详情.
   * @param orderDetails orderDetails
   * @return int
   */
  public int addOrderDetails(List<OrderDetail> orderDetails);

  /**
   * 添加预约订单.
   *
   * @param orderSubScribe orderSubScribe
   * @return int
   */
  public int addSubScribe(OrderSubScribe orderSubScribe);

  /**
   * 修改订单信息.
   *
   * @param orderDto orderDto
   * @return OrderDto
   */
  public int updateOrder(OrderDto orderDto);

  /**
   * 根据OrderDto获取订单列表.
   * @param pager pager
   * @param orderDto orderDto
   * @return Pager
   */
  public Pager<OrderDto> findOrders(Pager pager,OrderDto orderDto);

  /**
   * 根据订单id查询菜单详情.
   * @param orderId orderId
   * @return List
   */
  public List<OrderDetail> findDetails(Long orderId);

  /**
   * 通过OrderId获取订单详情.
   * @param orderId orderId
   * @return OrderDto
   */
  public OrderDto getOrderById(Long orderId);

  /**
   * 通过merChantId和状态标示获取订单销量.
   * @param merChantId merChantId
   * @param status 用逗号间隔，可传多个状态例 "1,2,3"
   * @return Integer
   */
  Integer getSalesByMerchantId(Long merChantId, String status);

  /**
   * 根据订单号获取订单信息.
   * @param number number
   * @return OrderDto
   */
  OrderDto getOrderByNumer(String number);

  /**
   * 根据食品id查看食品销量.
   * @param orderDetails orderDetails
   * @return OrderDetail
   */
  List<OrderDetail> getFoodSales(List<Integer> orderDetails);
}
