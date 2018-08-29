package com.example.administrator.fivepagelibrary.fragment;

import android.view.View;
import com.example.administrator.commonlibrary.bese.BaseViewFragment;
import com.example.administrator.commonlibrary.contract.fragment.five.FiveFragmentContract;
import com.example.administrator.commonlibrary.welcomepage.MainActivity;
import com.example.administrator.fivepagelibrary.R;
import com.example.administrator.fivepagelibrary.presenter.FiveFragmentPresenter;

public class FiveFragment extends BaseViewFragment<MainActivity,FiveFragmentContract.Presenter> implements FiveFragmentContract.View{

    @Override
    protected FiveFragmentContract.Presenter initPresenter() {
        return new FiveFragmentPresenter();
    }

    @Override
    protected int onMLayout() {
        return R.layout.five_fragment;
    }

    @Override
    protected void onHidden() {

    }

    @Override
    protected void onMView(View view) {

    }

    public static  FiveFragment newInstance() {
        return new FiveFragment();
    }
}
