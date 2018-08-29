package com.example.administrator.commonlibrary.bese;

import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
@Keep
public abstract class BaseFragment<T extends BaseViewActivity> extends Fragment{

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(onMLayout(), container, false);
        onMView(view);
        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            onHidden();
        }
    }

    /*
     * 初始化布局
     * */
    protected abstract int onMLayout();
    /*
     * 由于导航没有跟viewpager 结合，所以只能使用这个方法
     * */
    protected abstract void onHidden();
    /*
     * 初始化控件
     * */
    protected abstract void onMView(View view);

    public T getMyActivity() {
        try {
            return (T) getActivity();
        } catch (Exception e) {
            return null;
        }
    }
}
