package com.project.web.service.impl;

import com.project.sdk.common.Pager;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.food.FoodDto;
import com.project.sdk.export.dto.merchant.MerchantExportDto;
import com.project.sdk.export.dto.order.OrderDetailExportDto;
import com.project.sdk.export.dto.order.OrderExportDto;
import com.project.sdk.export.service.food.FoodExportService;
import com.project.sdk.export.service.merchant.MerchantExportService;
import com.project.sdk.export.service.order.OrderExportService;
import com.project.web.service.OrderService;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


/**
 * 订单OrderService实现.
 * Created by sun on 2017/7/25.
 */
@Service
public class OrderServiceImpl implements OrderService {

  @Resource
  private OrderExportService orderExportService;
  @Resource
  private MerchantExportService merchantExportService;
  @Resource
  private FoodExportService foodExportService;

  @Override
  public Pager<OrderExportDto> queryList(Pager pager, OrderExportDto orderExportDto) {
    Pager<OrderExportDto> pager1 = new Pager<OrderExportDto>();
    try {
      pager1 = orderExportService.findOrders(pager, orderExportDto);
      if (pager1.getRecords() != null) {
        for (OrderExportDto orderExportDto1 : pager1.getRecords()) {
          ExecuteResult<MerchantExportDto> merchantExportDto =
                  merchantExportService.queryMerchantDtoById(
                  Integer.valueOf(String.valueOf(orderExportDto1.getMerchantId())));
          orderExportDto1.setMerchantName(merchantExportDto.getResult().getName());
        }
      }
    } catch (Exception e) {
      pager1.setErrorMessage(e.getMessage());
    }
    return pager1;
  }

  @Override
  public ExecuteResult<OrderExportDto> saveOrderInfo(OrderExportDto orderExportDto) {
    ExecuteResult<OrderExportDto> result = new ExecuteResult<OrderExportDto>();
    if (orderExportDto.getMerchantId() != null) {
      if (orderExportDto.getStatus() != null) {
        if (orderExportDto.getType() != null) {
          if (orderExportDto.getOrderDetails() != null
                  && orderExportDto.getOrderDetails().size() != 0) {
            try {
              double sum = 0;
              for (OrderDetailExportDto orderDetailExportDto : orderExportDto.getOrderDetails()) {
                sum = BigDecimal.valueOf(sum).add(orderDetailExportDto.getPrice().multiply(
                        BigDecimal.valueOf(orderDetailExportDto.getNum()))).doubleValue();
              }
              orderExportDto.setPrice(BigDecimal.valueOf(sum));
              result = orderExportService.addOrder(orderExportDto);
            } catch (Exception e) {
              result.setErrorMessage(e.getMessage());
            }
          } else {
            result.setErrorMessage("订单详情不能为空");
          }
        } else {
          result.setErrorMessage("订单类型不能为空");
        }
      } else {
        result.setErrorMessage("订单状态不能为空");
      }
    } else {
      result.setErrorMessage("店铺信息不能为空");
    }
    return result;
  }

  @Override
  public ExecuteResult<OrderExportDto> updateOrder(OrderExportDto orderExportDto) {
    ExecuteResult<OrderExportDto> result = new ExecuteResult<OrderExportDto>();
    try {
      result = orderExportService.updateOrder(orderExportDto);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }

  @Override
  public ExecuteResult<List<OrderDetailExportDto>> findOrderDetail(Long orderId) {
    ExecuteResult<List<OrderDetailExportDto>> result =
            new ExecuteResult<List<OrderDetailExportDto>>();
    try {
      result = orderExportService.findOrderDetailByOrderId(orderId);
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }

  @Override
  public ExecuteResult<OrderExportDto> getOrderById(Long id) {
    ExecuteResult<OrderExportDto> result = new ExecuteResult<>();
    try {
      result = orderExportService.getOrderById(id);
      ExecuteResult<MerchantExportDto> merchantResult = merchantExportService.queryMerchantDtoById(
              Integer.valueOf(String.valueOf(result.getResult().getMerchantId())));
      if (merchantResult.isSuccess()) {
        result.getResult().setMerchantName(merchantResult.getResult().getName());
        result.getResult().setMerchantImgUrl(merchantResult.getResult().getImgurl());
        FoodDto foodDto = new FoodDto();
        for (OrderDetailExportDto order : result.getResult().getOrderDetails()) {
          foodDto.getFoodIdList().add(String.valueOf(order.getFoodId()));
        }
        ExecuteResult<List<FoodDto>> foodResult = foodExportService.queryList(foodDto);
        if (foodResult.isSuccess()) {
          for (OrderDetailExportDto orderDetailExportDto : result.getResult().getOrderDetails()) {
            for (FoodDto foodDto1 : foodResult.getResult()) {
              if (String.valueOf(orderDetailExportDto.getFoodId()).equals(
                      String.valueOf(foodDto1.getId()))) {
                orderDetailExportDto.setFoodName(foodDto1.getName());
                orderDetailExportDto.setImgurl(foodDto1.getImgurl());
              }
            }
          }
        } else {
          result.setErrorMessage("网络异常，获取信息失败");
        }
      } else {
        result.setErrorMessage("网络异常，获取信息失败");
      }
    } catch (Exception e) {
      result.setErrorMessage(e.getMessage());
    }
    return result;
  }

  @Override
  public ExecuteResult<OrderExportDto> getOrderByNumer(String number) {
    ExecuteResult<OrderExportDto> result = orderExportService.getOrderByNumber(number);
    if (result.isSuccess()) {
      ExecuteResult<MerchantExportDto> merchantResult = merchantExportService.queryMerchantDtoById(
              Integer.valueOf(String.valueOf(result.getResult().getMerchantId())));
      if (merchantResult.isSuccess()) {
        result.getResult().setMerchantImgUrl(merchantResult.getResult().getImgurl());
        result.getResult().setMerchantName(merchantResult.getResult().getName());
        FoodDto foodDto = new FoodDto();
        for (OrderDetailExportDto order : result.getResult().getOrderDetails()) {
          foodDto.getFoodIdList().add(String.valueOf(order.getFoodId()));
        }
        ExecuteResult<List<FoodDto>> foodResult = foodExportService.queryList(foodDto);
        if (foodResult.isSuccess()) {
          for (OrderDetailExportDto orderDetailExportDto : result.getResult().getOrderDetails()) {
            for (FoodDto foodDto1 : foodResult.getResult()) {
              if (String.valueOf(orderDetailExportDto.getFoodId()).equals(
                      String.valueOf(foodDto1.getId()))) {
                orderDetailExportDto.setImgurl(foodDto1.getImgurl());
                orderDetailExportDto.setFoodName(foodDto1.getName());
              }
            }
          }
        } else {
          result.setErrorMessage("网络异常，获取信息失败");
        }
      } else {
        result.setErrorMessage("网络异常，获取信息失败");
      }
    }
    return result;
  }
}
