package com.example.administrator.twopagelibrary;

import com.example.administrator.commonlibrary.bese.BaseViewActivity;
import com.example.administrator.commonlibrary.contract.activity.MaiAcivityContract;
import com.example.administrator.twopagelibrary.presenter.MaiActivityPresenter;


public class MainActivity extends BaseViewActivity<MaiAcivityContract.Presenter> implements MaiAcivityContract.View  {



    @Override
    protected void myOnCreate() {

    }

    @Override
    protected int onLayout() {
        return R.layout.two_activity_main;
    }

    @Override
    protected MaiAcivityContract.Presenter initPresenter() {
        return new MaiActivityPresenter();
    }
}
