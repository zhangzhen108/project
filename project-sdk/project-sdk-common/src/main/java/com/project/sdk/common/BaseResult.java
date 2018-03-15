package com.project.sdk.common;

import java.io.Serializable;

/**
 * BaseResult.
 * Created by sun on 2017/5/11.
 */
public class BaseResult implements Serializable {
  private static final long serialVersionUID = -1402660249534674131L;
  private Boolean success;
  private Integer resultCode;
  private String resultMsg;
  private String errorMessage;

  public BaseResult() {
  }

  public boolean isSuccess() {
    if ("".equals(this.errorMessage) || this.errorMessage == null) {
      this.success = true;
    } else {
      this.success = false;
    }
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = Boolean.valueOf(success);
  }

  public Boolean getOriginSuccess() {
    return this.success;
  }

  public String getResultMsg() {
    return this.resultMsg;
  }

  public void setResultMsg(String resultMsg) {
    this.resultMsg = resultMsg;
  }

  public int getResultCode() {
    return this.resultCode == null ? 0 : this.resultCode.intValue();
  }

  public Integer getOriginResultCode() {
    return this.resultCode;
  }

  public void setResultCode(int resultCode) {
    this.resultCode = Integer.valueOf(resultCode);
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}

