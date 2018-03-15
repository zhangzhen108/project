package com.project.sdk.service.impl;

import com.project.sdk.common.Pager;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.dto.order.OrderDetail;
import com.project.sdk.dto.order.OrderDto;
import com.project.sdk.dto.order.OrderSubScribe;
import com.project.sdk.mapper.order.OrderDetailMapper;
import com.project.sdk.mapper.order.OrderMapper;
import com.project.sdk.mapper.order.OrderSubScribeMapper;
import com.project.sdk.service.OrderService;

import java.util.ArrayList;
import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * OrderService实现.
 * Created by sun on 2017/7/12.
 */
@Service
public class OrderServiceImpl implements OrderService {
  @Resource
  private OrderMapper orderMapper;
  @Resource
  private OrderDetailMapper orderDetailMapper;
  @Resource
  private OrderSubScribeMapper orderSubScribeMapper;

  @Override
  @Transactional
  public OrderDto addOrderInfo(OrderDto orderDto, List<OrderDetail> list) {
    orderMapper.addOrder(orderDto);
    for (OrderDetail orderDetail : list) {
      orderDetail.setOrderId(orderDto.getId());
    }
    orderDetailMapper.addOrderDetails(list);
    return orderDto;
  }

  @Override
  @Transactional
  public int addOrderDetail(OrderDetail orderDetail) {
    return orderDetailMapper.addOrderDetail(orderDetail);
  }

  @Override
  @Transactional
  public int addOrderDetails(List<OrderDetail> orderDetails) {
    return orderDetailMapper.addOrderDetails(orderDetails);
  }

  @Override
  @Transactional
  public int addSubScribe(OrderSubScribe orderSubScribe) {
    return orderSubScribeMapper.addOrderSubScribe(orderSubScribe);
  }

  @Override
  @Transactional
  public int updateOrder(OrderDto orderDto) {
    orderDto.setCreateTime(null);
    orderDto.setCreateUser(null);
    return orderMapper.updateOrder(orderDto);
  }

  @Override
  public Pager<OrderDto> findOrders(Pager pager, OrderDto orderDto) {
    Pager<OrderDto> pager1 = new Pager<OrderDto>();
    List<OrderDto> list = orderMapper.findOrders(pager, orderDto);
    pager1.setTotalCount(orderMapper.queryCount(orderDto));
    pager1.setRecords(list);
    return pager1;
  }

  @Override
  public List<OrderDetail> findDetails(Long orderId) {
    return orderDetailMapper.findListByOrderId(orderId);
  }

  @Override
  public OrderDto getOrderById(Long orderId) {
    return orderMapper.queryById(orderId);
  }

  @Override
  public Integer getSalesByMerchantId(Long merChantId, String status) {
    String[] astate = status.split(",");
    List<String> strings = new ArrayList<>();
    for (int i = 0; i < astate.length; i++) {
      strings.add(astate[i]);
    }
    return orderMapper.getSalesByMerchantId(merChantId, strings);
  }

  @Override
  public OrderDto getOrderByNumer(String number) {
    return orderMapper.getOrderByNumer(number);
  }

  @Override
  public List<OrderDetail> getFoodSales(List<Integer> orderDetails) {
    return orderDetailMapper.getFoodSales(orderDetails);
  }
}
