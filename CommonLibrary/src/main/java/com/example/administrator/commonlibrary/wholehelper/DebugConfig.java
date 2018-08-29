package com.example.administrator.commonlibrary.wholehelper;
/**
 * @author wang_hong_wei
 * @description 设置App 测试模式 还是 打包模式
 * @Date 2018-6-1
 */
public class DebugConfig {
    //各个平台的ID
    public   final static String bugId="d0ea5fce51";


    public final static int MODE_DEBUG=0;  //测试模式
    public final static int MODE_RELEASE=1;//打包模式
    public  static Boolean BUGLY_DEBUG;//腾讯bugly的debug模式
    public  static boolean  LOG_UTILS;  //日志打印模式
    public  static boolean  BUG_TOSAT;  //吐司模式
    public static void init(int build){
        switch (build){
            case MODE_RELEASE:
                BUGLY_DEBUG=false;
                LOG_UTILS=false;
                BUG_TOSAT=false;
                break;
            case MODE_DEBUG:
                BUGLY_DEBUG=true;
                LOG_UTILS=true;
                BUG_TOSAT=true;
                break;
        }
    }
}
