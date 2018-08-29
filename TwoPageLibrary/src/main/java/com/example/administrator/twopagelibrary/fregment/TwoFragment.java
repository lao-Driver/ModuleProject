package com.example.administrator.twopagelibrary.fregment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;


import com.example.administrator.commonlibrary.bese.BaseFragment;
import com.example.administrator.commonlibrary.bese.BaseViewFragment;
import com.example.administrator.commonlibrary.contract.fragment.two.TwoFragmentContract;
import com.example.administrator.commonlibrary.utils.LogUtil;

import com.example.administrator.commonlibrary.utils.ToastUtils;
import com.example.administrator.commonlibrary.welcomepage.MainActivity;
import com.example.administrator.twopagelibrary.R;
import com.example.administrator.twopagelibrary.presenter.TwoFragmentPresenter;
public class TwoFragment extends BaseViewFragment<MainActivity,TwoFragmentContract.Presenter> implements TwoFragmentContract.View {
    @Override
    protected TwoFragmentContract.Presenter initPresenter() {
        return new TwoFragmentPresenter();
    }

    @Override
    protected int onMLayout() {
        return R.layout.two_fragment;
    }

    @Override
    protected void onHidden() {
        LogUtil.d("Two---onHidden");
    }

    @Override
    protected void onMView(View view) {
        TextView text = view.findViewById(R.id.two_content);
        text.setTextColor(Color.RED);
        text.setText(" 第二个页面....k");
    }


    public static BaseFragment newInstance() {
        return new TwoFragment();
    }
}
