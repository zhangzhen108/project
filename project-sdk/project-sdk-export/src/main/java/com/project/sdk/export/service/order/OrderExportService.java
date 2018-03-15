package com.project.sdk.export.service.order;


import com.project.sdk.common.Pager;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.order.OrderDetailExportDto;
import com.project.sdk.export.dto.order.OrderExportDto;

import java.util.List;


/**
 * 订单exportService
 * Created by sun on 2017/7/12.
 */
public interface OrderExportService {

  /**
   * 添加订单信息，订单详情请放OrderExportDto中的orderDetails.
   *
   * @param orderExportDto orderExportDto
   * @return OrderExportDto
   */
  ExecuteResult<OrderExportDto> addOrder(OrderExportDto orderExportDto);

  /**
   * 修改订单信息(修改人修改时间以及状态修改).
   *
   * @param orderExportDto orderExportDto
   * @return OrderExportDto
   */
  ExecuteResult<OrderExportDto> updateOrder(OrderExportDto orderExportDto);

  /**
   * 根据订单id查询订单详情.
   *
   * @param orderId orderId
   * @return List
   */
  ExecuteResult<List<OrderDetailExportDto>> findOrderDetailByOrderId(Long orderId);

  /**
   * 根据订单id查询订单，内包含订单详情.
   *
   * @param id id
   * @return OrderExportDto
   */
  ExecuteResult<OrderExportDto> getOrderById(Long id);

  /**
   * 查询订单列表 page存放分页信息
   * orderExportDto存放订单查询条件，createUser存放用户id.
   *
   * @param page           page
   * @param orderExportDto orderExportDto
   * @return Pager
   */
  Pager<OrderExportDto> findOrders(Pager page, OrderExportDto orderExportDto);

  /**
   * 通过merChantId和状态标示获取订单销量.
   * @param merChantId merChantId
   * @return Integer
   */
  ExecuteResult<Integer> getSalesByMerchantId(Long merChantId, String status);

  /**
   * 根据订单号获取订单信息.
   * @param number number
   * @return OrderExportDto
   */
  ExecuteResult<OrderExportDto> getOrderByNumber(String number);

  /**
   * 根据食品id获取食品销量.
   * @param details details
   * @return OrderDetailExportDto
   */
  ExecuteResult<List<OrderDetailExportDto>> getFoodSales(List<Integer> details);

}
