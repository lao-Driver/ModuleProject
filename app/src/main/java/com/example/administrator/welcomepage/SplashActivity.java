package com.example.administrator.welcomepage;



import android.content.Intent;

import com.example.administrator.R;
import com.example.administrator.commonlibrary.bese.BaseViewActivity;
import com.example.administrator.commonlibrary.contract.activity.GuidanceActivityContract;
import com.example.administrator.commonlibrary.utils.ToastUtils;
import com.example.administrator.commonlibrary.welcomepage.GuidanceActivity;
import com.example.administrator.commonlibrary.welcomepage.MainActivity;
import com.example.administrator.commonlibrary.welcomepage.presenter.GuidancePresenter;

import static com.example.administrator.commonlibrary.utils.ActivityUtils.newIntent;


public class SplashActivity extends BaseViewActivity<GuidanceActivityContract.Presenter> implements GuidanceActivityContract.View{


    @Override
    protected GuidanceActivityContract.Presenter initPresenter() {
        return new GuidancePresenter(this);
    }

    @Override
    protected void myOnCreate() {

    }

    @Override
    protected int onLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void toMain() {
       newIntent(MainActivity.class).startActivity(this);
       finish();
    }

    @Override
    public void toGuide() {
        newIntent(GuidanceActivity.class).startActivity(this);
        finish();
    }
}
