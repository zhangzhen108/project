package com.project.sdk.export.dto.merchant;

import java.util.Date;

public class MerchantCollectExportDto {

  /**
   * id.
   */
  private Integer id;

  /**
   * 用户id.
   */
  private Integer userId;

  /**
   * 店铺id.
   */
  private Integer collectId;

  private Date createTime;

  private Date updateTime;

  /**
   * 0--无效 1--有效
   */
  private String status;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getCollectId() {
    return collectId;
  }

  public void setCollectId(Integer collectId) {
    this.collectId = collectId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}