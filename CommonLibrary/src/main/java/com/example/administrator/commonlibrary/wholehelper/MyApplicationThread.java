package com.example.administrator.commonlibrary.wholehelper;

import android.app.IntentService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;


/**
 * @author wang_hong_wei
 * @description 用于初始化第三方数据 的线程
 * @Date 2018-6-1
 */
@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class MyApplicationThread extends IntentService {



    public MyApplicationThread() {
        super("MyApplicationThread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }


}
