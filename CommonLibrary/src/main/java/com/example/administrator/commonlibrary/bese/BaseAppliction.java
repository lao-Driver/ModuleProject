package com.example.administrator.commonlibrary.bese;

import android.app.Application;
import android.content.Intent;

import com.example.administrator.commonlibrary.contract.fragment.five.FiveFragmentContract;
import com.example.administrator.commonlibrary.contract.fragment.four.FourFragmentContract;
import com.example.administrator.commonlibrary.contract.fragment.one.OneFragmentContract;
import com.example.administrator.commonlibrary.contract.fragment.three.ThreeFragmentContract;
import com.example.administrator.commonlibrary.contract.fragment.two.TwoFragmentContract;
import com.example.administrator.commonlibrary.utils.ToastUtils;
import com.example.administrator.commonlibrary.utils.system.APKVersionCodeUtils;
import com.example.administrator.commonlibrary.utils.system.Utils;
import com.example.administrator.commonlibrary.utils.system.ClassUtils;
import com.example.administrator.commonlibrary.wholehelper.DebugConfig;
import com.example.administrator.commonlibrary.wholehelper.MyApplicationThread;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseAppliction  extends Application {
    List<BaseFragment> fragments;    //Fragment集合
    private static BaseAppliction baseAppliction;

    @Override
    public void onCreate() {
        super.onCreate();
        baseAppliction=this;
        //设置app  测试或者打包模式
         DebugConfig.init(DebugConfig.MODE_RELEASE);
        //初始化数据的线程
        Intent intent=new Intent(this,MyApplicationThread.class);
        startService(intent);
        Utils.init(this);
        //查找出 指定包下面的主界面的所有Fragment
        getNewsFragment();
    }
    public static BaseAppliction getBaseAppliction(){
        return baseAppliction;
    }
    public  List<BaseFragment>  getNewsFragment() {
        if (fragments==null) {
            fragments = new ArrayList<>();
             BaseFragment[] fragmenArray = new BaseFragment[5];
            List<IViewDelegate> viewDelegates = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.example.administrator");
            if (viewDelegates != null && !viewDelegates.isEmpty()) {
                for (IViewDelegate view : viewDelegates) {
                   if (view.getFragment() instanceof OneFragmentContract.View){
                       fragmenArray[0]=view.getFragment();
                    }else if(view.getFragment() instanceof TwoFragmentContract.View){
                       fragmenArray[1]=view.getFragment();
                    }else if(view.getFragment() instanceof ThreeFragmentContract.View){
                       fragmenArray[3]=view.getFragment();
                    }else if(view.getFragment() instanceof FourFragmentContract.View){
                       fragmenArray[4]=view.getFragment();
                    }else if(view.getFragment() instanceof FiveFragmentContract.View){
                       fragmenArray[2]=view.getFragment();
                    }
                }
            }
            fragments = Arrays.asList(fragmenArray);
        }
        return this.fragments;
    }
}
