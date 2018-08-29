package com.example.administrator.commonlibrary.contract.fragment.four;

import com.example.administrator.commonlibrary.bese.BaseContract;

public class FourFragmentContract {
    public  interface Model {
    }

    public interface View extends BaseContract.BaseView{
    }

    public interface Presenter extends BaseContract.BasePresenter<FourFragmentContract.View> {
    }
}
