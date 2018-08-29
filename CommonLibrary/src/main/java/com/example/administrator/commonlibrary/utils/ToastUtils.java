package com.example.administrator.commonlibrary.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.administrator.commonlibrary.bese.BaseAppliction;
import com.example.administrator.commonlibrary.wholehelper.DebugConfig;


/**
 * @author wang_hong_wei
 * @description 吐司工具类
 * @Date 2018-5-11
 */
public class ToastUtils {
    private static Toast mToast;

    /**
     * 显示对话框
     *
     * @param content 要显示的内容
     */
    public static void showToast(Context context, String content) {
        if (mToast == null) {
            mToast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setText(content);
        }
        mToast.show();
    }

    public static void showToast(String content) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseAppliction.getBaseAppliction(), content, Toast.LENGTH_SHORT);
        } else {
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setText(content);
        }
        mToast.show();
    }
    public static void showLongToast(Context context, String content) {
        if (mToast == null) {
            mToast = Toast.makeText(context, content, Toast.LENGTH_LONG);
        } else {
            mToast.setDuration(Toast.LENGTH_LONG);
            mToast.setText(content);
        }
        mToast.show();
    }

    public static void showLongToast(String content) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseAppliction.getBaseAppliction(), content, Toast.LENGTH_LONG);
        } else {
            mToast.setDuration(Toast.LENGTH_LONG);
            mToast.setText(content);
        }
        mToast.show();
    }
    public static void bugToast(String content) {
        if (DebugConfig.BUG_TOSAT) {
            if (mToast == null) {
                mToast = Toast.makeText(BaseAppliction.getBaseAppliction(), content, Toast.LENGTH_SHORT);
            } else {
                mToast.setDuration(Toast.LENGTH_SHORT);
                mToast.setText(content);
            }
            mToast.show();
        }
    }

}
