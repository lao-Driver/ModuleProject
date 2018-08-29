package com.example.administrator.fivepagelibrary;




import com.example.administrator.commonlibrary.bese.BaseViewActivity;
import com.example.administrator.commonlibrary.contract.activity.MaiAcivityContract;
import com.example.administrator.fivepagelibrary.presenter.MaiActivityPresenter;


public class MainActivity extends BaseViewActivity<MaiAcivityContract.Presenter> implements MaiAcivityContract.View {


    @Override
    protected void myOnCreate() {

    }

    @Override
    protected int onLayout() {
        return R.layout.five_activity_main;
    }

    @Override
    protected MaiAcivityContract.Presenter initPresenter() {
        return new MaiActivityPresenter();
    }
}
