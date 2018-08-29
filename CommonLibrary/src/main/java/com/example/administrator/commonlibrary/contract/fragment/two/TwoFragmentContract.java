package com.example.administrator.commonlibrary.contract.fragment.two;


import com.example.administrator.commonlibrary.bese.BaseContract;

public class TwoFragmentContract {
    public  interface Model {
    }

    public interface View extends BaseContract.BaseView{
    }

    public interface Presenter extends BaseContract.BasePresenter<TwoFragmentContract.View> {
    }
}
