package com.example.administrator.commonlibrary.contract.activity;


import com.example.administrator.commonlibrary.bese.BaseContract;
public class GuidanceActivityContract {
    public  interface Model {
    }

    public interface View extends BaseContract.BaseView {
        void toMain();
        void toGuide();
    }

    public interface Presenter extends BaseContract.BasePresenter<GuidanceActivityContract.View> {

    }
}
