package com.project.sdk.export.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单详情类
 * Created by sun on 2017/7/13.
 */
public class OrderDetailExportDto implements Serializable {
  /**
   * 订单ID.
   */
  private Long orderId;
  /**
   * 食品id.
   */
  private Long foodId;
  /**
   * 食品名称.
   */
  private String foodName;
  /**
   * 食品价格.
   */
  private BigDecimal price;
  /**
   * 食品数量.
   */
  private Integer num;

  /**
   * 食品图片URL.
   */
  private String imgurl;

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

  public String getFoodName() {
    return foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
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

  public String getImgurl() {
    return imgurl;
  }

  public void setImgurl(String imgurl) {
    this.imgurl = imgurl;
  }
}
