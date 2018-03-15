package com.project.sdk.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sun on 2017/7/12.
 * 订单
 */
public class OrderDto {
  private Long id;

  private Long merchantId;
  /**
   * 订单类型  0--实时订单 1--预约订单.
   */
  private Integer type;

  /**
   * 订单号.
   */
  private String number;

  /**
   * 订单状态（0删除，1订单已提交，2订单已付款，3订单完成）.
   */
  private Integer status;
  /**
   * 订单金额.
   */
  private BigDecimal price;

  /**
   * 用户ID.
   */
  private Integer userId;

  private Date createTime;

  private Long createUser;

  private Date updateTime;

  private Long updateUser;

  private String remark;

  private String seatNumber;

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Long merchantId) {
    this.merchantId = merchantId;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Long getCreateUser() {
    return createUser;
  }

  public void setCreateUser(Long createUser) {
    this.createUser = createUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Long getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(Long updateUser) {
    this.updateUser = updateUser;
  }
}
