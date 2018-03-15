package com.project.web.controller;

import com.dreamCommon.common.UUID.SnowflakeIdWorker;
import com.project.sdk.common.Pager;
import com.project.sdk.common.page.ExecuteResult;
import com.project.sdk.export.dto.order.OrderExportDto;
import com.project.web.service.OrderService;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * 订单Order.
 * Created by sun on 2017/7/25.
 */
@Controller
@RequestMapping("order")
public class OrderController {

  private static SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0, 0);

  @Resource
  private OrderService orderService;

  /**
   * 查询分页订单.
   *
   * @param pager          pager
   * @param orderExportDto orderExportDto
   * @return String
   */
  @ResponseBody
  @RequestMapping("/queryList")
  public String queryList(Pager pager, OrderExportDto orderExportDto) {
    Pager<OrderExportDto> result = new Pager<OrderExportDto>();
    try {
      result = orderService.queryList(pager, orderExportDto);
    } catch (Exception e) {
      result.setResultMsg(JSONObject.fromObject(e).toString());
    }
    return JSONObject.fromObject(result).toString();
  }

  /**
   * 保存订单信息.
   *
   * @param orderExportDto orderExportDto
   * @return String
   */
  @ResponseBody
  @RequestMapping("/saveOrderInfo")
  public String saveOrderInfo(@RequestBody OrderExportDto orderExportDto) {
    ExecuteResult<OrderExportDto> result = new ExecuteResult<OrderExportDto>();
    try {
      if (orderExportDto.getCreateUser() != null) {
        orderExportDto.setNumber(String.valueOf(snowflakeIdWorker.nextId()));
        orderExportDto.setCreateTime(new Date());
        orderExportDto.setUpdateUser(orderExportDto.getCreateUser());
        orderExportDto.setUpdateTime(orderExportDto.getCreateTime());
        result = orderService.saveOrderInfo(orderExportDto);
      } else {
        result.setErrorMessage("订单创建人不能为空");
      }
    } catch (Exception e) {
      result.setErrorMessage(JSONObject.fromObject(e).toString());
    }
    return JSONObject.fromObject(result).toString();
  }

  /**
   * 保存订单信息.
   *
   * @param orderExportDto orderExportDto
   * @return String
   */
  @ResponseBody
  @RequestMapping("/updateOrder")
  public String updateOrder(OrderExportDto orderExportDto) {
    ExecuteResult<OrderExportDto> result = new ExecuteResult<OrderExportDto>();
    try {
      if (orderExportDto.getUpdateUser() != null) {
        orderExportDto.setUpdateTime(new Date());
        result = orderService.updateOrder(orderExportDto);
      } else {
        result.setErrorMessage("订单的更新人不能为空");
      }
    } catch (Exception e) {
      result.setErrorMessage(JSONObject.fromObject(e).toString());
    }
    return JSONObject.fromObject(result).toString();
  }

  /**
   * 通过订单id获取订单详细信息.
   *
   * @param orderId orderId
   * @return String
   */
  @ResponseBody
  @RequestMapping("/findOrderDetail")
  public String findOrderDetail(Long orderId) {
    ExecuteResult<OrderExportDto> result = new ExecuteResult<>();
    try {
      result = orderService.getOrderById(orderId);
    } catch (Exception e) {
      result.setErrorMessage(JSONObject.fromObject(e).toString());
    }
    return JSONObject.fromObject(result).toString();
  }

  /**
   * 通过订单号获取订单详细信息.
   *
   * @param number number
   * @return String
   */
  @ResponseBody
  @RequestMapping("/findOrderByNumber")
  public String findOrderByNumber(String number) {
    ExecuteResult<OrderExportDto> result = new ExecuteResult<>();
    try {
      result = orderService.getOrderByNumer(number);
    } catch (Exception e) {
      result.setErrorMessage(JSONObject.fromObject(e).toString());
    }
    return JSONObject.fromObject(result).toString();
  }
}
