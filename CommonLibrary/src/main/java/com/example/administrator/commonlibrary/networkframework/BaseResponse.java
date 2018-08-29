package com.example.administrator.commonlibrary.networkframework;

/**
 * description:retrofit的base响应对象
 * Created by CharlesYao on 2017/6/5.
 * email: ychdevelop@dingtalk.com
 */

public class  BaseResponse {
    private boolean success;
    private String errorCode;
    private String message;

    public BaseResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "success=" + success +
                ", errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
