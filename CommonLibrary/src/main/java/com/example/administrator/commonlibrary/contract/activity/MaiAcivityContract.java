package com.example.administrator.commonlibrary.contract.activity;


import com.example.administrator.commonlibrary.bese.BaseContract;
public class MaiAcivityContract {
    public  interface Model {
    }

    public interface View extends BaseContract.BaseView{
    }

    public interface Presenter extends BaseContract.BasePresenter<MaiAcivityContract.View> {
    }
}
