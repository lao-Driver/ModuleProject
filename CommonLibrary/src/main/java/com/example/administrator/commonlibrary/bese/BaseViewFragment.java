package com.example.administrator.commonlibrary.bese;

import android.content.Context;


/**
 * @author wang_hong_wei
 * @description fregment的基类
 * @Date 2018-5-11
 */

public abstract class BaseViewFragment<T extends BaseViewActivity,P extends BaseContract.BasePresenter>
        extends BaseFragment<T> implements BaseContract.BaseView {

    protected P mPresenter;

    @Override
    public Context getContext() {
        return getActivity().getApplicationContext();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // 初始化Presenter
        mPresenter = initPresenter();
        mPresenter.attachView(this);

    }


    /*
     * 实例化P层对象
     * */
    protected abstract P initPresenter();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {

    }

    @Override
    public void showToast(String content) {
        getMyActivity().showToast(content);
    }


}
