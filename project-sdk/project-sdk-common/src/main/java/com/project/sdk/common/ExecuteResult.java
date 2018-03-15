package com.project.sdk.common;

/**
 * ExecuteResult.
 * Created by sun on 2017/5/11.
 */

import java.io.Serializable;

/**.
 * 执行结果信息类，用于封装增删改方法的结果信息
 * 失败时必须将错误信息设置到errorMessages中
 */
public class ExecuteResult<T> extends BaseResult implements Serializable {

  private static final long serialVersionUID = -1854616725284151074L;

  private T result;// 执行成功返回结果集

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }
}
