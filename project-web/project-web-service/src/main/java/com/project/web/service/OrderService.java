package com.project.web.service;

import com.project.sdk.common.Pager;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.order.OrderDetailExportDto;
import com.project.sdk.export.dto.order.OrderExportDto;

import java.util.List;


/**
 * 订单Service.
 * Created by sun on 2017/7/25.
 */
public interface OrderService {

  /**
   * 条件查询订单信息.
   * @param pager pager
   * @param orderExportDto orderExportDto
   * @return Pager
   */
  Pager<OrderExportDto> queryList(Pager pager, OrderExportDto orderExportDto);

  /**
   * 保存订单信息.
   * @param orderExportDto orderExportDto
   * @return ExecuteResult
   */
  ExecuteResult<OrderExportDto> saveOrderInfo(OrderExportDto orderExportDto);

  /**
   * 修改订单信息.
   * @param orderExportDto orderExportDto
   * @return ExecuteResult
   */
  ExecuteResult<OrderExportDto> updateOrder(OrderExportDto orderExportDto);

  /**
   * 获取订单详情.
   * @param orderId orderId
   * @return List
   */
  ExecuteResult<List<OrderDetailExportDto>> findOrderDetail(Long orderId);

  /**
   * 根据订单id查询订单，内包含订单详情.
   *
   * @param id id
   * @return OrderExportDto
   */
  ExecuteResult<OrderExportDto> getOrderById(Long id);

  /**
   * 根据订单号获取订单信息.
   * @param number number
   * @return OrderExportDto
   */
  ExecuteResult<OrderExportDto> getOrderByNumer(String number);
}
