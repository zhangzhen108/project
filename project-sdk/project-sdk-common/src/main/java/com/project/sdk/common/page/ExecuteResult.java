package com.project.sdk.common.page;

import java.io.Serializable;

/**
 * Created by zhangzhen on 2017/7/14.
 */
public class ExecuteResult<T> implements Serializable{

    private T result;

    private int  status;

    private boolean  isSuccess=true;

    private String errorMessage;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        if("".equals(this.errorMessage) || this.errorMessage==null){
            this.isSuccess=true;
        }else{
            this.isSuccess=false;
        }
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
