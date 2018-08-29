package com.example.administrator.commonlibrary.bese;

import android.content.Context;


/**
 * @author wang_hong_wei
 * @description mvp的抽象类
 * @Date 2018-5-11
 */

public class BaseContract {

    public interface BaseView {

        Context getContext();

        void showLoadingDialog();
        void dismissLoadingDialog();
        void showToast(String content);
    }

    public interface BasePresenter<T extends BaseView> {

        void attachView(T view);

        void detachView();

    }
}
