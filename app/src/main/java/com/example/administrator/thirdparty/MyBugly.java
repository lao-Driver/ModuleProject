package com.example.administrator.thirdparty;

import android.content.Context;


import com.example.administrator.commonlibrary.utils.ToastUtils;
import com.example.administrator.commonlibrary.wholehelper.DebugConfig;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
;


public class MyBugly {
    public static void init(Context context){
        // 设置是否开启热更新能力，默认为true
      //  Beta.enableHotfix = true;
        // 设置是否自动下载补丁
     //   Beta.canAutoDownloadPatch = true;
        // 设置是否提示用户重启
      //  Beta.canNotifyUserRestart = true;
        // 设置是否自动合成补丁
      //  Beta.canAutoPatch = true;
       Bugly.init(context, DebugConfig.bugId, DebugConfig.BUGLY_DEBUG);
    }
}
