package com.example.administrator.commonlibrary.bese;



import com.example.administrator.commonlibrary.networkframework.MyConsumer;
import com.example.administrator.commonlibrary.networkframework.RetrofitClient;
import com.example.administrator.commonlibrary.networkframework.RetrofitInterface;
import com.example.administrator.commonlibrary.utils.NetUtils;

import org.reactivestreams.Subscription;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * @author wang_hong_wei
 * @description MVP Activity 解绑的基类
 * CompositeDisposable  的使用https://www.jianshu.com/p/b672724dbff8
 * @Date 2018-5-31
 */
public abstract class BasePresenterImpl<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    protected Reference<T> mViewRef;//view接口类型的弱引用
    protected CompositeDisposable mCompositeDisposable;
    private Consumer onNoxt;
    private  Consumer error;
    private  Consumer susser;
    protected RetrofitInterface flowable;
    private Action action;

    @Override
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);//建立关联
        flowable = RetrofitClient.getInstance().create(RetrofitInterface.class);       //retrofit初始化
        mCompositeDisposable = new CompositeDisposable();
        attachView();
    }

    @Override
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    /*
     * 运行在 Activity 的onCreate()生命周期中
     * */
    protected abstract void attachView();


    protected T getView() {
        return mViewRef.get();
    }

    /*
     * 判断 是否解绑
     * */
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void addSubscription(Flowable observable, final MyConsumer consumer){
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        if (susser==null){
            susser=  new Consumer<Subscription>(){
                @Override
                public void accept(Subscription subscription) throws Exception {
                    subscription.request(Long.MAX_VALUE);//Rxjava2 被压策略
                }
            };
        }
        onNoxt=  new Consumer<Object>(){
           @Override
           public void accept(Object e) throws Exception {
               if (consumer!=null)
               consumer.onNoxt(e);
           }
       };
        error=  new Consumer<Throwable>(){
            @Override
            public void accept(Throwable throwable) throws Exception {
                getMessage(throwable,consumer);
            }
        };
        action = new Action() {
            @Override
            public void run() throws Exception {

            }
        };
        mCompositeDisposable.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNoxt,error,action,susser));
    }

  public void getMessage(Throwable e,MyConsumer consumer){
      if (e instanceof retrofit2.HttpException) {
          retrofit2.HttpException httpException = (retrofit2.HttpException) e;
          int code = httpException.code();
          String msg = httpException.getMessage();
          if (httpException.response().toString()==null) {
              msg = "请重新登录";
          }
          if (code == 504) {
              msg = "网络不给力";
          }
          if (code == 500) {
              msg = "请求失败";
          }
          if (code == 502 || code == 404) {
              msg = "服务器异常，请稍后再试";
          }
         if (consumer!=null)consumer.onError(msg);
      } else {
          if(!NetUtils.isNetworkConnected(BaseAppliction.getBaseAppliction())){
           if (consumer!=null)consumer.onError("(╯▽╰)加载不出来...好像\\n没网啦...");
          }
      }
  }
}
