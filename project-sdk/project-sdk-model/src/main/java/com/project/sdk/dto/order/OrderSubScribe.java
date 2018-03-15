package com.project.sdk.dto.order;

import java.io.Serializable;

/**
 * 订单预约.
 * Created by sun on 2017/7/13.
 */
public class OrderSubScribe {

  private Long id;
  /**
   * 订单id.
   */
  private Long orderId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }
}
