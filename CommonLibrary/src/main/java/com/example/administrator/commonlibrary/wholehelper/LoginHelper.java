package com.example.administrator.commonlibrary.wholehelper;


import com.example.administrator.commonlibrary.utils.SharedPreferenceUtil;

/**
 * @author wang_hong_wei
 * @description 用户登录管理类
 * @Date 2018-5-11
 */

public class LoginHelper {

    /**
     * 查看用户是否登录
     *
     * @return true 表示登录状态, false 表示未登录
     */
   /* public static boolean isLogin() {
        String token = getUserSharedPreferences().getString(Constants.TOKEN);
        return !Strings.isNullOrEmpty(token);
    }*/

    /**
     * 清除用户登录状态
     */
  /*  public static void clearLoginState(Activity activity) {
        // 清除用户本地信息存储
        getUserSharedPreferences().clare();

        // 清除微信登录状态
        LoginHelper.deleteOauth(activity, null);
        LoginHelper.deleteOauthqq(activity, null);

        // 清除我的页面信息
        RxBus.getInstance().post(new LogOffEvent());
    }*/



    /**
     * 退出登录时取消授权 (微信)
     *
     * @param umAuthListener umAuthListener
     */
   /* public static void deleteOauth(Activity activity, UMAuthListener umAuthListener) {
        UMShareAPI.get(activity).deleteOauth(activity, SHARE_MEDIA.WEIXIN.toSnsPlatform().mPlatform, umAuthListener);
    }*/

    /**
     * 退出登录时取消授权 (微信)
     *
     * @param umAuthListener umAuthListener
     */
  /*  public static void deleteOauthqq(Activity activity, UMAuthListener umAuthListener) {
        UMShareAPI.get(activity).deleteOauth(activity, SHARE_MEDIA.QQ.toSnsPlatform().mPlatform, umAuthListener);
    }*/
    /**
     * 登录第三方 (微信)
     *
     * @param activity       activity
     * @param umAuthListener umAuthListener
     */
  /*  public static void doOauthVerify(Activity activity, UMAuthListener umAuthListener) {
        UMShareAPI.get(activity).doOauthVerify(activity, SHARE_MEDIA.WEIXIN.toSnsPlatform().mPlatform, umAuthListener);
    }*/
    /**
     * 登录第三方 (qq)
     *
     * @param activity       activity
     * @param umAuthListener umAuthListener
     */
   /* public static void doOauthVerifyqq(Activity activity, UMAuthListener umAuthListener) {
        UMShareAPI.get(activity).doOauthVerify(activity, SHARE_MEDIA.QQ.toSnsPlatform().mPlatform, umAuthListener);
    }*/
    /**
     * 获取用户信息 (qq)
     *
     * @param activity       activity
     * @param umAuthListener umAuthListener
     */
    /*public static void getPlatformInfoqq(Activity activity, UMAuthListener umAuthListener) {
        UMShareAPI.get(activity).getPlatformInfo(activity, SHARE_MEDIA.QQ, umAuthListener);
    }*/
    /**
     * 获取用户信息 (微信)
     *
     * @param activity       activity
     * @param umAuthListener umAuthListener
     */
   /* public static void getPlatformInfo(Activity activity, UMAuthListener umAuthListener) {
        UMShareAPI.get(activity).getPlatformInfo(activity, SHARE_MEDIA.WEIXIN, umAuthListener);
    }*/


    /**
     * 校验APP是否首次登录
     *
     * @return 包含返回true，不包含返回false
     */
    public static boolean isFirstLogin() {
        return getUserSharedPreferences().getBoolean(VariableHelper.IS_FIRST_LOGIN, true);
    }

    /**
     * 获取用户信息SP
     *
     * @return SharedPreferenceUtils
     */
    public static SharedPreferenceUtil getUserSharedPreferences() {
        return SharedPreferenceUtil.getInstance().setSharedPreferences(VariableHelper.SP_NAME_USER);
    }
}
