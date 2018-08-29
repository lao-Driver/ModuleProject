package com.example.administrator.fourpagelibrary;

import android.support.annotation.Keep;


import com.example.administrator.commonlibrary.bese.BaseFragment;
import com.example.administrator.commonlibrary.bese.IViewDelegate;
import com.example.administrator.fourpagelibrary.fregment.FourFragment;


/**
 * <p>类说明</p>
 *
 * @author 张华洋 2018/1/4 22:16
 * @version V2.8.3
 * @name MyViewDelegate
 */
@Keep
public class MyViewDelegate implements IViewDelegate {

    @Override
    public BaseFragment getFragment() {
        return FourFragment.newInstance();
    }


}
