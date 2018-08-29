package com.example.administrator.commonlibrary.utils;

import android.util.Log;

import com.example.administrator.commonlibrary.wholehelper.DebugConfig;

import java.util.Stack;


public class LogUtil {

    private static final String TAG = "LogUtil";
    private static final String TAG_TRACE_TIME = "LogUtil_TraceTime";

    /**
     * Send a VERBOSE log message.
     */
    public static void v(String tag, String msg) {
        if (DebugConfig.LOG_UTILS) {
            Log.v(tag, buildMessage(msg));
        }
    }

    public static void v(String msg) {
        if (DebugConfig.LOG_UTILS) {
            Log.v(TAG, buildMessage(msg));
        }
    }

    /**
     * Send a DEBUG_LOG log message.
     */
    public static void d(String tag, String msg) {
        if (DebugConfig.LOG_UTILS) {
            Log.d(tag, buildMessage(msg));
        }
    }

    public static void d(String msg) {
        if (DebugConfig.LOG_UTILS) {
            Log.d(TAG, buildMessage(msg));
        }
    }

    /**
     * Send an INFO log message.
     */
    public static void i(String tag, String msg) {
        if (DebugConfig.LOG_UTILS) {
            Log.i(tag, buildMessage(msg));
        }
    }

    public static void i(String msg) {
        if (DebugConfig.LOG_UTILS) {
            Log.i(TAG, buildMessage(msg));
        }
    }

    /**
     * Send a WARN log message
     */
    public static void w(String tag, String msg) {
        if (DebugConfig.LOG_UTILS) {
            Log.w(tag, buildMessage(msg));
        }
    }

    public static void w(String msg) {
        if (DebugConfig.LOG_UTILS) {
            Log.w(TAG, buildMessage(msg));
        }
    }

    /**
     * Send an ERROR log message.
     */
    public static void e(String tag, String msg, Throwable throwable) {
        if (DebugConfig.LOG_UTILS) {
            Log.e(tag, buildMessage(msg), throwable);
        }
    }

    public static void e(String tag, String msg) {
        if (DebugConfig.LOG_UTILS) {
            Log.e(tag, buildMessage(msg));
        }
    }

    public static void e(String msg) {
        if (DebugConfig.LOG_UTILS) {
            Log.e(TAG, buildMessage(msg));
        }
    }

    public static void e(String msg, Throwable throwable) {
        if (DebugConfig.LOG_UTILS) {
            Log.e(TAG, buildMessage(msg), throwable);
        }
    }


    /**
     * printStackTrace
     */
    public static void printStackTrace(Throwable throwable) {
        if (DebugConfig.LOG_UTILS) {
            Log.e(TAG, buildMessage("printStackTrace -> "), throwable);
            throwable.printStackTrace();
        }
    }

    /**
     * TraceTime
     */
    private static Stack<Long> traceTimeStack = new Stack<>();

    public static void resetTraceTime() {
        traceTimeStack.clear();
    }

    public static void startTraceTime(String msg) {
        traceTimeStack.push(System.currentTimeMillis());
        if (DebugConfig.LOG_UTILS) {
            Log.d(TAG_TRACE_TIME, msg + " time = " + System.currentTimeMillis());
        }
    }

    public static void stopTraceTime(String msg) {
        if (!traceTimeStack.isEmpty()) {
            long time = traceTimeStack.pop();
            long diff = System.currentTimeMillis() - time;
            if (DebugConfig.LOG_UTILS) {
                Log.d(TAG_TRACE_TIME, "[" + diff + "]" + msg + " time = " + System.currentTimeMillis());
            }
        }
    }

    /**
     * Building Message
     */
    protected static String buildMessage(String msg) {
        StackTraceElement caller = new Throwable().fillInStackTrace().getStackTrace()[2];
        StringBuilder builder = new StringBuilder();
        if (DebugConfig.LOG_UTILS) {
            builder.append(caller.getClassName());
            builder.append(".");
            builder.append(caller.getMethodName());
            builder.append("(): \n");
        }
        builder.append(msg);
        return builder.toString();
    }
}
