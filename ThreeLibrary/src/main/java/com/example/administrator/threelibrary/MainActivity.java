package com.example.administrator.threelibrary;




import com.example.administrator.commonlibrary.bese.BaseViewActivity;
import com.example.administrator.commonlibrary.contract.activity.MaiAcivityContract;
import com.example.administrator.threelibrary.presenter.MaiActivityPresenter;
import com.example.administrator.threepagelibrary.R;


public class MainActivity extends BaseViewActivity<MaiAcivityContract.Presenter> implements MaiAcivityContract.View {



    @Override
    protected void myOnCreate() {

    }

    @Override
    protected int onLayout() {
        return R.layout.three_activity_main;
    }

    @Override
    protected MaiAcivityContract.Presenter initPresenter() {
        return new MaiActivityPresenter();
    }
}
