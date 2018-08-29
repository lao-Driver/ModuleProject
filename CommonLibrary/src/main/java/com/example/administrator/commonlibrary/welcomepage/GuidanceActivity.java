package com.example.administrator.commonlibrary.welcomepage;



import android.view.View;

import com.example.administrator.commonlibrary.R;
import com.example.administrator.commonlibrary.bese.BaseViewActivity;
import com.example.administrator.commonlibrary.contract.activity.GuidanceActivityContract;
import com.example.administrator.commonlibrary.utils.ActivityUtils;
import com.example.administrator.commonlibrary.welcomepage.presenter.GuidancePresenter;
import com.example.administrator.commonlibrary.wholehelper.VariableHelper;
import static com.example.administrator.commonlibrary.wholehelper.LoginHelper.getUserSharedPreferences;


/**
 * @author wang_hong_wei
 * @description 引导页
 * @Date 2018-5-11
 */
public class GuidanceActivity extends BaseViewActivity<GuidanceActivityContract.Presenter> implements GuidanceActivityContract.View {

    @Override
    protected void myOnCreate() {

    }

    @Override
    protected int onLayout() {
        return R.layout.activity_guidance;
    }

    @Override
    protected GuidanceActivityContract.Presenter initPresenter() {
        return new GuidancePresenter(this);
    }


    @Override
    public void toMain() {

    }

    @Override
    public void toGuide() {

    }

    public void button(View view) {
        ActivityUtils.startActivity(this,MainActivity.class);
        getUserSharedPreferences().putBoolean(VariableHelper.IS_FIRST_LOGIN,false);
        finish();
    }
}
