package com.example.administrator.commonlibrary.networkframework;

import com.example.administrator.commonlibrary.BuildConfig;
import com.example.administrator.commonlibrary.bese.BaseAppliction;
import com.example.administrator.commonlibrary.wholehelper.RetrofitPath;


import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author wang_hong_wei
 * @description Retrofit的封装类
 * @Date 2018-5-11
 */
public class RetrofitClient {
    public static Retrofit mRetrofit=null;
    //接口对象的单例实现
    public static Retrofit getInstance(){

        if (mRetrofit==null) synchronized (RetrofitClient.class) {
            if (mRetrofit == null) {
                File cacheFile = new File(BaseAppliction.getBaseAppliction().getExternalCacheDir(), "RetrofitCache");
                if (!cacheFile.exists()) {
                    try {
                        cacheFile.mkdir();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
                //创建OKHttpClient的对象
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                if (BuildConfig.DEBUG) {
                    // Log信息拦截器
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            //Logger.t(TAG).i(message);
                        }
                    });

                    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    builder.addInterceptor(logging);
                }
                OkHttpClient okHttpClient =builder.retryOnConnectionFailure(true)//连接失败后是否重新连接
                        .connectTimeout(5000, TimeUnit.SECONDS)
                        .readTimeout(5000, TimeUnit.SECONDS)
                        .writeTimeout(5000, TimeUnit.SECONDS)
                        .cache(cache)
                        .addNetworkInterceptor(OKhttpInterceptor.cacheInterceptor)
                        .addInterceptor(OKhttpInterceptor.commonParamsInterceptor)
                        .build();
                //获取接口的对象
                mRetrofit=  new Retrofit.Builder()
                        .baseUrl(RetrofitPath.RETROFIT_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                        .client(okHttpClient)
                        .build();
            }
        }
        return mRetrofit;
    }
}
