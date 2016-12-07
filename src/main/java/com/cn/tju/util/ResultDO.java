package com.cn.tju.util;

/**
 * Created by search on 2016/11/14.
 */

import java.io.Serializable;

public class ResultDO<T> implements Serializable {

    private static final long serialVersionUID = -3518453422409559359L;

    /*
     * 返回模型
     */
    private T module;

    /*
     * 错误码
     */
    private String errorCode;

    /*
     * 是否业务成功
     */
    private boolean success = false;

    public T getModule() {
        return module;
    }

    public void setModule(T module) {
        this.module = module;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
