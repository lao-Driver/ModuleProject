package com.example.administrator.commonlibrary.networkframework;

/**
 * description:retrofit基本的响应对象:  适用于result为Object
 * Created by CharlesYao on 2017/6/4.
 * email: ychdevelop@dingtalk.com
 */

public class ResponseBean<T> extends BaseResponse {
    public ResponseBean() {
    }
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "result=" + result +
                '}';
    }
}
