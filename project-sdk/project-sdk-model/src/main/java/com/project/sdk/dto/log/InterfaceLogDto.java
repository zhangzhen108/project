package com.project.sdk.dto.log;

import java.util.Date;

/**
 * Created by sun on 2017/9/4.
 */
public class InterfaceLogDto {
  private Integer id;//id
  private String interfaceCode;
  private String interfaceName;
  private String interfaceReqJson;
  private String interfaceResJson;
  private Date createTime;
  private Date updateTime;
  private String createUser;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getInterfaceCode() {
    return interfaceCode;
  }

  public void setInterfaceCode(String interfaceCode) {
    this.interfaceCode = interfaceCode;
  }

  public String getInterfaceName() {
    return interfaceName;
  }

  public void setInterfaceName(String interfaceName) {
    this.interfaceName = interfaceName;
  }

  public String getInterfaceReqJson() {
    return interfaceReqJson;
  }

  public void setInterfaceReqJson(String interfaceReqJson) {
    this.interfaceReqJson = interfaceReqJson;
  }

  public String getInterfaceResJson() {
    return interfaceResJson;
  }

  public void setInterfaceResJson(String interfaceResJson) {
    this.interfaceResJson = interfaceResJson;
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

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }
}
