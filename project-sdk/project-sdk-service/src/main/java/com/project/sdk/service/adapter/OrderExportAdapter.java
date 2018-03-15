package com.project.sdk.service.adapter;


import com.project.sdk.common.Pager;
import com.project.sdk.common.Trans;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.dto.order.OrderDetail;
import com.project.sdk.dto.order.OrderDto;
import com.project.sdk.export.dto.order.OrderDetailExportDto;
import com.project.sdk.export.dto.order.OrderExportDto;
import com.project.sdk.export.service.order.OrderExportService;
import com.project.sdk.service.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


/**
 * 订单Export实现.
 * Created by sun on 2017/7/12.
 */
@Service("orderExportService")
public class OrderExportAdapter implements OrderExportService {

  @Resource
  private OrderService orderService;

  @Override
  public ExecuteResult<OrderExportDto> addOrder(OrderExportDto orderExportDto) {
    ExecuteResult<OrderExportDto> result = new ExecuteResult<OrderExportDto>();
    try {
      OrderDto orderDto = new OrderDto();
      orderDto = (OrderDto) Trans.transBeanToBeanDto(orderExportDto, orderDto);
      List<OrderDetail> orderDetails = (List) Trans.transListBeanToBeanDto(
              orderExportDto.getOrderDetails(), new OrderDetail());
      orderDto = orderService.addOrderInfo(orderDto, orderDetails);
      orderExportDto = (OrderExportDto) Trans.transBeanToBeanDto(orderDto, orderExportDto);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    result.setResult(orderExportDto);
    return result;
  }

  @Override
  public ExecuteResult<OrderExportDto> updateOrder(OrderExportDto orderExportDto) {
    ExecuteResult<OrderExportDto> result = new ExecuteResult<OrderExportDto>();
    if (orderExportDto.getUpdateUser() == null) {
      result.setErrorMessage("更新人不能为空");
      return result;
    }
    if (orderExportDto.getUpdateTime() == null) {
      orderExportDto.setUpdateTime(new Date());
    }
    try {
      OrderDto orderDto = new OrderDto();
      orderDto = (OrderDto) Trans.transBeanToBeanDto(orderExportDto, orderDto);
      orderService.updateOrder(orderDto);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }

  @Override
  public ExecuteResult<List<OrderDetailExportDto>> findOrderDetailByOrderId(Long orderId) {
    ExecuteResult<List<OrderDetailExportDto>> result =
            new ExecuteResult<List<OrderDetailExportDto>>();
    try {
      List<OrderDetail> list = orderService.findDetails(orderId);
      List<OrderDetailExportDto> list1 = (List) Trans.transListBeanToBeanDto(
              list, new OrderDetailExportDto());
      result.setResult(list1);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }

  @Override
  public ExecuteResult<OrderExportDto> getOrderById(Long id) {
    ExecuteResult<OrderExportDto> result = new ExecuteResult<OrderExportDto>();
    try {
      OrderDto orderDto = new OrderDto();
      orderDto = orderService.getOrderById(id);
      OrderExportDto orderExportDto = new OrderExportDto();
      orderExportDto = (OrderExportDto) Trans.transBeanToBeanDto(orderDto, orderExportDto);
      List<OrderDetail> list = orderService.findDetails(id);
      List<OrderDetailExportDto> list1 = (List) Trans.transListBeanToBeanDto(
              list, new OrderDetailExportDto());
      orderExportDto.setOrderDetails(list1);
      result.setResult(orderExportDto);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }

  @Override
  public Pager<OrderExportDto> findOrders(Pager page, OrderExportDto orderExportDto) {
    Pager<OrderExportDto> pager = new Pager<OrderExportDto>();
    try {
      OrderDto orderDto = new OrderDto();
      orderDto = (OrderDto) Trans.transBeanToBeanDto(orderExportDto, orderDto);
      Pager<OrderDto> orderPager = orderService.findOrders(page, orderDto);
      pager = (Pager) Trans.transBeanToBeanDto(orderPager, pager);
      List<OrderExportDto> orderExportDtos = new ArrayList<OrderExportDto>();
      orderExportDtos = (List) Trans.transListBeanToBeanDto(
              orderPager.getRecords(), new OrderExportDto());
      pager.setRecords(orderExportDtos);
    } catch (Exception e) {
      pager.setErrorMessage(e.getMessage());
    }
    return pager;
  }

  @Override
  public ExecuteResult<Integer> getSalesByMerchantId(Long merChantId, String status) {
    ExecuteResult<Integer> result = new ExecuteResult<>();
    try {
      result.setResult(orderService.getSalesByMerchantId(merChantId, status));
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }

  @Override
  public ExecuteResult<OrderExportDto> getOrderByNumber(String number) {
    ExecuteResult<OrderExportDto> result = new ExecuteResult<>();
    try {
      OrderDto orderDto = orderService.getOrderByNumer(number);
      OrderExportDto orderExportDto = new OrderExportDto();
      orderExportDto = (OrderExportDto) Trans.transBeanToBeanDto(orderDto, orderExportDto);
      result.setResult(orderExportDto);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }

  @Override
  public ExecuteResult<List<OrderDetailExportDto>> getFoodSales(List<Integer> foodIds) {
    ExecuteResult<List<OrderDetailExportDto>> result = new ExecuteResult<>();
    try {
      List<OrderDetail> list = orderService.getFoodSales(foodIds);
      List<OrderDetailExportDto> list2 = (List) Trans.transListBeanToBeanDto(list,new OrderDetailExportDto());
      result.setResult(list2);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }
}
