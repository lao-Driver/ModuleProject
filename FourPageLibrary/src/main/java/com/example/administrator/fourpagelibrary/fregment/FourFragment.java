package com.example.administrator.fourpagelibrary.fregment;

import android.view.View;
import android.widget.TextView;


import com.example.administrator.commonlibrary.bese.BaseViewFragment;
import com.example.administrator.commonlibrary.contract.fragment.four.FourFragmentContract;
import com.example.administrator.commonlibrary.utils.LogUtil;
import com.example.administrator.commonlibrary.welcomepage.MainActivity;
import com.example.administrator.fourpagelibrary.R;
import com.example.administrator.fourpagelibrary.presenter.FourFragmentPresenter;


public class FourFragment  extends BaseViewFragment<MainActivity,FourFragmentContract.Presenter> implements FourFragmentContract.View {
    @Override
    protected FourFragmentContract.Presenter initPresenter() {
        return new FourFragmentPresenter();
    }

    @Override
    protected int onMLayout() {
        LogUtil.d("Four---onCreterView");
        return R.layout.four_fragment;
    }

    @Override
    protected void onHidden() {
        LogUtil.d("Four---onHidden");
    }

    @Override
    protected void onMView(View view) {
        TextView text = view.findViewById(R.id.four_content);
        text.setText(" 第四个页面");
    }
    @Override
    public void onResume() {
        super.onResume();
        LogUtil.d("Four---onResume");
    }
    @Override
    public void onPause() {
        super.onPause();
        LogUtil.d("Four---onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.d("Four---onStop");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.d("Four---onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("Four---onDestroy");
    }


    public static FourFragment newInstance() {
        return new FourFragment();
    }
}
