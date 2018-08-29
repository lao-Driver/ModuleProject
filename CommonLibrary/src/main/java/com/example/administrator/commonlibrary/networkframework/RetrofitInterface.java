package com.example.administrator.commonlibrary.networkframework;




import com.example.administrator.commonlibrary.bean.MyBean;
import com.example.administrator.commonlibrary.wholehelper.RetrofitPath;

import java.util.HashMap;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;


public interface RetrofitInterface {
    @POST(RetrofitPath.HOME_HEALTH_LIST)
    Flowable<MyBean> getHomeHealthList();

    @Multipart
    @POST()  //上传json串 配合 FastJsonRequestBodyConverter 类使用
    Flowable<MyBean> getSpeedinessAddData(@QueryMap HashMap<String, String> params, @Part("indicatorList") RequestBody route);
}
