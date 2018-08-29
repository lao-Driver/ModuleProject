package com.example.administrator.commonlibrary.networkframework;


import java.util.List;

/**
 * description: retrofit基本的响应对象:  适用于result为集合泛型为object时
 * Created by CharlesYao on 2017/6/5.
 * email: ychdevelop@dingtalk.com
 */

public class ResponseListBean<T> extends BaseResponse {
    List<T> result;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return "ResponseListBean{" +
                "result=" + result +
                '}';
    }
}
