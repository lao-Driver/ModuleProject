package com.example.administrator.threelibrary.fregment;

import android.view.View;
import android.widget.TextView;


import com.example.administrator.commonlibrary.bese.BaseFragment;
import com.example.administrator.commonlibrary.bese.BaseViewFragment;
import com.example.administrator.commonlibrary.contract.fragment.three.ThreeFragmentContract;
import com.example.administrator.commonlibrary.utils.LogUtil;
import com.example.administrator.commonlibrary.welcomepage.MainActivity;
import com.example.administrator.threelibrary.presenter.ThreeFragmentPresenter;
import com.example.administrator.threepagelibrary.R;


public class ThreeFragment  extends BaseViewFragment<MainActivity,ThreeFragmentContract.Presenter> implements ThreeFragmentContract.View {
    @Override
    protected ThreeFragmentContract.Presenter initPresenter() {
        return new ThreeFragmentPresenter();
    }

    @Override
    protected int onMLayout() {
        LogUtil.d("Three---onCreterView");
        return R.layout.three_fragment;
    }

    @Override
    protected void onHidden() {
        LogUtil.d("Three---onHidden");
    }

    @Override
    protected void onMView(View view) {
        TextView text = view.findViewById(R.id.three_content);
        text.setText(" 第三个页面");
    }
    @Override
    public void onResume() {
        super.onResume();
        LogUtil.d("Three---onResume");
    }
    @Override
    public void onPause() {
        super.onPause();
        LogUtil.d("Three---onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.d("Three---onStop");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.d("Three---onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("Three---onDestroy");
    }


    public static BaseFragment newInstance() {
        return new ThreeFragment();
    }
}
