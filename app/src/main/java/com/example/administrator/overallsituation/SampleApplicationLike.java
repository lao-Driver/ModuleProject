package com.example.administrator.overallsituation;



import android.content.Context;
import android.support.multidex.MultiDex;

import com.example.administrator.commonlibrary.bese.BaseAppliction;
import com.example.administrator.thirdparty.MyBugly;

import com.tencent.bugly.beta.Beta;


public class SampleApplicationLike extends BaseAppliction {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context= getApplicationContext();
        //腾讯bugly  由于bugly不能再线程中初始化
        MyBugly.init(this);
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        // 安装tinker
        Beta.installTinker();
    }

}
