package com.project.sdk.dto.order;

import java.math.BigDecimal;

/**
 * 订单详情
 * Created by sun on 2017/7/13.
 */
public class OrderDetail {
  private Long orderId;
  private Long foodId;
  private BigDecimal price;
  private Integer num;

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getFoodId() {
    return foodId;
  }

  public void setFoodId(Long foodId) {
    this.foodId = foodId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }
}
