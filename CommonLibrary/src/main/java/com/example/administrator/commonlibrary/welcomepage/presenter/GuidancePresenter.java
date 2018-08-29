package com.example.administrator.commonlibrary.welcomepage.presenter;




import com.example.administrator.commonlibrary.bese.BasePresenterImpl;
import com.example.administrator.commonlibrary.contract.activity.GuidanceActivityContract;
import com.example.administrator.commonlibrary.wholehelper.VariableHelper;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

import static com.example.administrator.commonlibrary.wholehelper.LoginHelper.getUserSharedPreferences;

public class GuidancePresenter extends BasePresenterImpl<GuidanceActivityContract.View> implements GuidanceActivityContract.Presenter{
    //默认闪屏时间
    private static final int DURATION_DEFAULT_SPLASH = 2000;
    private GuidanceActivityContract.View view;
    public GuidancePresenter(GuidanceActivityContract.View view){
        this.view=view;
    }
    @Override
    protected void attachView() {
        Observable
                .timer(DURATION_DEFAULT_SPLASH, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if(getUserSharedPreferences().getBoolean(VariableHelper.IS_FIRST_LOGIN,true)){
                            view.toGuide();
                        }else{
                            view.toMain();
                        }
                    }
                });
   /*addSubscription(flowable.getHomeHealthList(), new MyConsumer<MyBean>() {


       @Override
       public void onNoxt(MyBean accept) {

       }

       @Override
       public void onError(String msg) {
     Toast.makeText(MyApplication.context,msg,Toast.LENGTH_SHORT).show();
       }
   });*/

}
}