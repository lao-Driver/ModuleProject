package com.example.administrator.commonlibrary.contract.fragment.three;


import com.example.administrator.commonlibrary.bese.BaseContract;

public class ThreeFragmentContract {
    public  interface Model {
    }

    public interface View extends BaseContract.BaseView{
    }

    public interface Presenter extends BaseContract.BasePresenter<ThreeFragmentContract.View> {
    }
}
