package com.example.administrator.commonlibrary.bese;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.commonlibrary.utils.ToastUtils;


/**
 * @author wang_hong_wei
 * @description MVP Activity 解绑的基类
 * @Date 2018-5-30
 */
public abstract class BaseViewActivity<T extends BaseContract.BasePresenter> extends BaseActivity implements BaseContract.BaseView  {
    protected T mPresenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 初始化Presenter
        mPresenter = initPresenter();
        mPresenter.attachView(this);
        myOnCreate();
    }
    protected abstract T initPresenter();
    protected abstract void myOnCreate();



    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
    /*
    *全局上下文
    * */
    @Override
    public Context getContext() {
        return getApplicationContext();
    }


    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {

    }

    @Override
    public void showToast(String content) {
        ToastUtils.showToast(this,content);
    }

   /*
   * 设置横竖屏
   * */

    @Override
    protected int getScreenOrientation() {
        return ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT;
    }


    /**
     * 点击非焦点区域隐藏软软盘
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);

    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            // 获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

}
