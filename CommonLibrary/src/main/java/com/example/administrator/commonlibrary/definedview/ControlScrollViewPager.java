package com.example.administrator.commonlibrary.definedview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * @author wang_hong_wei
 * @description 自定义ViewPager类 实现Viewpager不可滑动
 * @Date 2018-6-9
 */
public class ControlScrollViewPager extends ViewPager {
    private boolean isCanScroll = false;
    private OnBannerClick onBannerClick;
    private  int scrollY;
    public ControlScrollViewPager(Context context) {
        super(context);
    }

    public ControlScrollViewPager(Context context, AttributeSet attrs) {

        super(context, attrs);

    }



    public void setScanScroll(boolean isCanScroll){
        this.isCanScroll = isCanScroll;

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        this.scrollY=t;
        this.scrollY=l;
    }



    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!isCanScroll){
            return false;
        }
        return super.onInterceptHoverEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (onBannerClick!=null){
                    onBannerClick.onDown();
                }
                scrollY=0;
                break;
            case MotionEvent.ACTION_UP:
                if (onBannerClick!=null){
                    onBannerClick.onUp();
                }
                scrollY=0;
                break;
            case MotionEvent.ACTION_CANCEL:
                if (onBannerClick!=null){
                    onBannerClick.onCancle();
                }
                scrollY=0;
                break;
            case MotionEvent.ACTION_MOVE:
                if (onBannerClick!=null){
                    onBannerClick.onMove(scrollY);
                }
                scrollY=0;
                break;
        }
        if (!isCanScroll){
            return false;
        }
        return super.onTouchEvent(ev);

    }

    public interface  OnBannerClick{
        void  onDown();
        void  onUp();
        void  onCancle();
        void onMove(int y);
    }

    public void setOnBannerClick(OnBannerClick onBannerClick){
        this.onBannerClick=onBannerClick;
    }
}
