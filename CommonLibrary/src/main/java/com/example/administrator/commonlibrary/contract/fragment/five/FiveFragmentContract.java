package com.example.administrator.commonlibrary.contract.fragment.five;

import com.example.administrator.commonlibrary.bese.BaseContract;

public class FiveFragmentContract {
    public  interface Model {
    }

    public interface View extends BaseContract.BaseView{
    }

    public interface Presenter extends BaseContract.BasePresenter<FiveFragmentContract.View> {
    }
}
