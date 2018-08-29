package com.example.administrator.commonlibrary.contract.fragment.one;


import com.example.administrator.commonlibrary.bese.BaseContract;

public class OneFragmentContract {
    public  interface Model {
    }

    public interface View extends BaseContract.BaseView{
    }

    public interface Presenter extends BaseContract.BasePresenter<OneFragmentContract.View> {
    }
}
