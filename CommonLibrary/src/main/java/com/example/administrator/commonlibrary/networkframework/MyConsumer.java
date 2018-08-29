package com.example.administrator.commonlibrary.networkframework;

/**
 * @author wang_hong_wei
 * @description retrofit 成功与失败的回调
 * @Date 2018-5-11
 */
public interface MyConsumer<T> {
    void onNoxt(T accept);
    void onError(String mag);
}
