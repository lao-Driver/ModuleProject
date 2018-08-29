package com.example.administrator.onepagelibrary.activity;



import com.example.administrator.commonlibrary.bese.BaseViewActivity;
import com.example.administrator.commonlibrary.contract.activity.MaiAcivityContract;
import com.example.administrator.commonlibrary.contract.fragment.one.OneFragmentContract;

import com.example.administrator.onepagelibrary.R;
import com.example.administrator.onepagelibrary.presenter.OneFragmentPresenter;

public class HuadongActivity extends BaseViewActivity<OneFragmentContract.Presenter> implements MaiAcivityContract.View {


    @Override
    protected void myOnCreate() {

    }

    @Override
    protected int onLayout() {
        return R.layout.one_fragment;
    }

    @Override
    protected OneFragmentContract.Presenter initPresenter() {
        return new OneFragmentPresenter();
    }
}
