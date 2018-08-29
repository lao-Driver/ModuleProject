package com.example.administrator.commonlibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.administrator.commonlibrary.R;
import com.example.administrator.commonlibrary.bese.BaseAppliction;




/**
 * @author wang_hong_wei
 * @description Activity  跳转的帮助类
 * @Date 2018-5-11
 */
public class ActivityUtils {

    private static final String INTENT_EXTRA_PREFIX = "activity_utils_intent_extra";

//================================================ Activity跳转相关 ================================================//

    public static void startActivity(Activity context, Class<?> activity) {
        context.startActivity(new Intent(context, activity));
        context.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);//这部分代码是切换Activity时的动画，看起来就不会很生硬
    }

    public static IntentBuilder newIntent(Class<?> activity) {
        return new IntentBuilder(activity);
    }

    public static IntentBuilder newIntent() {
        return new IntentBuilder();
    }

    public static void startActivityWithData(Activity context, Class<?> activity, String... data) {
        Intent intent = new Intent(context, activity);
        for (int i = 0; i < data.length; i++) {
            intent.putExtra(INTENT_EXTRA_PREFIX + i, data[i]);
        }
        context.startActivity(intent);
    }

    public static String getStringExtra(Activity activity) {
        return activity.getIntent().getStringExtra(INTENT_EXTRA_PREFIX + "_string");
    }

    public static String getStringExtra(Activity activity, int index) {
        return activity.getIntent().getStringExtra(INTENT_EXTRA_PREFIX + "_string" + index);
    }

    public static String getStringExtra(Activity activity, String key) {
        return activity.getIntent().getStringExtra(key);
    }

    public static int getIntExtra(Activity activity) {
        return activity.getIntent().getIntExtra(INTENT_EXTRA_PREFIX + "_int", 0);
    }

    public static int getIntExtra(Activity activity, int index) {
        return activity.getIntent().getIntExtra(INTENT_EXTRA_PREFIX + "_int" + index, 0);
    }

    public static int getIntExtra(Activity activity, String key) {
        return activity.getIntent().getIntExtra(key, 0);
    }

    public static boolean getBooleanExtra(Activity activity, boolean defValue) {
        return activity.getIntent().getBooleanExtra(INTENT_EXTRA_PREFIX + "_boolean", defValue);
    }

    public static boolean getBooleanExtra(Activity activity, int index, boolean defValue) {
        return activity.getIntent().getBooleanExtra(INTENT_EXTRA_PREFIX + "_boolean" + index, defValue);
    }

    public static boolean getBooleanExtra(Activity activity, String key, boolean defValue) {
        return activity.getIntent().getBooleanExtra(key, defValue);
    }


    /**
     * 为启用链式编程而创建用来管理intent的类
     */
    public static class IntentBuilder {
        private Intent intent;

        public IntentBuilder() {
            intent = new Intent();
        }

        public IntentBuilder(Class<?> activity) {
            intent = new Intent(BaseAppliction.getBaseAppliction(), activity);
        }

        public IntentBuilder putExtra(String value) {
            intent.putExtra(INTENT_EXTRA_PREFIX + "_string", value);
            return this;
        }

        public IntentBuilder putExtra(String value, int index) {
            intent.putExtra(INTENT_EXTRA_PREFIX + "_string" + index, value);
            return this;
        }

        public IntentBuilder putExtra(String value, String key) {
            intent.putExtra(key, value);
            return this;
        }

        public IntentBuilder putExtra(boolean value) {
            intent.putExtra(INTENT_EXTRA_PREFIX + "_boolean", value);
            return this;
        }

        public IntentBuilder putExtra(boolean value, int index) {
            intent.putExtra(INTENT_EXTRA_PREFIX + "_boolean" + index, value);
            return this;
        }

        public IntentBuilder putExtra(boolean value, String key) {
            intent.putExtra(key, value);
            return this;
        }

        public IntentBuilder putExtra(int value) {
            intent.putExtra(INTENT_EXTRA_PREFIX + "_int", value);
            return this;
        }

        public IntentBuilder putExtra(int value, int index) {
            intent.putExtra(INTENT_EXTRA_PREFIX + "_int" + index, value);
            return this;
        }

        public IntentBuilder putExtra(int value, String key) {
            intent.putExtra(key, value);
            return this;
        }

        public IntentBuilder putExtra(long value, String key) {
            intent.putExtra(key, value);
            return this;
        }

        public IntentBuilder putExtra(float value, String key) {
            intent.putExtra(key, value);
            return this;
        }

        public IntentBuilder putExtra(double value, String key) {
            intent.putExtra(key, value);
            return this;
        }

        public IntentBuilder setData(Uri data) {
            intent.setData(data);
            return this;
        }

        public IntentBuilder setAction(String action) {
            intent.setAction(action);
            return this;
        }

        public IntentBuilder newTask() {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            return this;
        }

        public void startActivity(Context activity) {
            activity.startActivity(intent);
        }

        public void startActivityForResult(Activity activity, int requestCode) {
            activity.startActivityForResult(intent, requestCode);
        }
    }


    //================================================ Activity相关方法 ================================================//

}
