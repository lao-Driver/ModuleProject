package com.example.administrator.onepagelibrary.fregment;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;


import com.example.administrator.commonlibrary.bese.BaseFragment;
import com.example.administrator.commonlibrary.bese.BaseViewFragment;
import com.example.administrator.commonlibrary.contract.fragment.one.OneFragmentContract;
import com.example.administrator.commonlibrary.utils.LogUtil;
import com.example.administrator.commonlibrary.welcomepage.MainActivity;
import com.example.administrator.onepagelibrary.R;
import com.example.administrator.onepagelibrary.activity.HuadongActivity;
import com.example.administrator.onepagelibrary.presenter.OneFragmentPresenter;

import static com.example.administrator.commonlibrary.utils.ActivityUtils.newIntent;


public class OneFragment extends BaseViewFragment<MainActivity,OneFragmentContract.Presenter> implements OneFragmentContract.View{

    @Override
    protected OneFragmentContract.Presenter initPresenter() {
        return new OneFragmentPresenter();
    }

    @Override
    protected int onMLayout() {
        LogUtil.d("One---onCreterView");
        return R.layout.one_fragment;
    }

    @Override
    protected void onHidden() {
        LogUtil.d("One---onHidden");
    }

    @Override
    protected void onMView(View view) {
        TextView text = view.findViewById(R.id.one_content);
        text.setText("点击跳转到一个Activity，可以实现右滑关闭Activity");
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             newIntent(HuadongActivity.class).startActivity(getMyActivity());
            }
        });
    }


    public static BaseFragment newInstance() {
        return new OneFragment();
    }
}
