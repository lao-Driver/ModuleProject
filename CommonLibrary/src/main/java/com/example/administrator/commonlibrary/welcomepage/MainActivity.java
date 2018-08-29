package com.example.administrator.commonlibrary.welcomepage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.administrator.commonlibrary.R;
import com.example.administrator.commonlibrary.bese.BaseAppliction;
import com.example.administrator.commonlibrary.bese.BaseFragment;
import com.example.administrator.commonlibrary.bese.BaseViewActivity;
import com.example.administrator.commonlibrary.contract.activity.MaiAcivityContract;
import com.example.administrator.commonlibrary.definedview.buttomtabs.AlphaTabsIndicator;
import com.example.administrator.commonlibrary.definedview.buttomtabs.OnTabChangedListner;
import com.example.administrator.commonlibrary.welcomepage.presenter.MaiActivityPresenter;


import java.util.ArrayList;
import java.util.List;



public class MainActivity extends BaseViewActivity<MaiAcivityContract.Presenter> implements MaiAcivityContract.View {

    private long exitTime;
    AlphaTabsIndicator mAlphaIndicator;
     // 记录上次点击（显示）的位置
    private int lastItemSelected = 0;
    private MaiActivityPresenter presenter;
    private final String ONE_FRAGMENT="one_fragment";
    private final String TWO_FRAGMENT="two_fragment";
    private final String THREE_FRAGMENT="three_fragment";
    private final String FOUR_FRAGMENT="four_fragment";
    private final String FIVE_FRAGMENT="five_fragment";
    private final String SELETE_INDEX="lastItemSelected";
    private List<BaseFragment> fragments=new ArrayList<>();
    @Override
    protected void myOnCreate() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAlphaIndicator = findViewById(R.id.alphaIndicator);
        List<BaseFragment> newsFragment = BaseAppliction.getBaseAppliction().getNewsFragment();
        fragments.addAll(newsFragment);
        if (savedInstanceState!=null){
            lastItemSelected = savedInstanceState.getInt(SELETE_INDEX, 0);
            /*获取保存的fragment  没有的话返回null*/
            BaseFragment fragment = (BaseFragment)getSupportFragmentManager().getFragment(savedInstanceState, ONE_FRAGMENT);
            BaseFragment fragment1 =(BaseFragment) getSupportFragmentManager().getFragment(savedInstanceState, TWO_FRAGMENT);
            BaseFragment fragment2 = (BaseFragment)getSupportFragmentManager().getFragment(savedInstanceState, FIVE_FRAGMENT);
            BaseFragment fragment3 = (BaseFragment)getSupportFragmentManager().getFragment(savedInstanceState, THREE_FRAGMENT);
            BaseFragment fragment4 =(BaseFragment) getSupportFragmentManager().getFragment(savedInstanceState, FOUR_FRAGMENT);
            if (fragment!=null)
            {   fragments.remove(0);
                fragments.add(0,fragment);
            }
            if (fragment1!=null) {
                fragments.remove(1);
                fragments.add(1,fragment1);
            }
            if (fragment2!=null){
                fragments.remove(2);
                fragments.add(2,fragment2);
            }
            if (fragment3!=null){
                fragments.remove(3);
                fragments.add(3,fragment3);
            }
            if (fragment4!=null){
                fragments.remove(4);
                fragments.add(4,fragment4);
            }
        }
        initFragment(fragments.get(0));
        mAlphaIndicator.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                changeFragment(lastItemSelected, tabNum);
            }
        });
    }

    @Override
    protected int onLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MaiAcivityContract.Presenter initPresenter() {
        presenter = new MaiActivityPresenter();
        return presenter;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
         outState.putInt(SELETE_INDEX,lastItemSelected);
        if (fragments.get(0) != null&&fragments.get(0).isAdded()) {
            getSupportFragmentManager().putFragment(outState, ONE_FRAGMENT, fragments.get(0));
        }
        if (fragments.get(1) != null&&fragments.get(1).isAdded()) {
            getSupportFragmentManager().putFragment(outState, TWO_FRAGMENT, fragments.get(1));
        }
        if (fragments.get(2) != null&&fragments.get(2).isAdded()) {
            getSupportFragmentManager().putFragment(outState, FIVE_FRAGMENT, fragments.get(2));
        }
        if (fragments.get(3) != null&&fragments.get(3).isAdded()) {
            getSupportFragmentManager().putFragment(outState, THREE_FRAGMENT, fragments.get(3));
        }
        if (fragments.get(4) != null&&fragments.get(4).isAdded()) {
            getSupportFragmentManager().putFragment(outState, FOUR_FRAGMENT, fragments.get(4));
        }
        super.onSaveInstanceState(outState);
    }

    private void initFragment(Fragment fragment) {
        if (!fragment.isAdded()){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.vp_content, fragment,"fragment0");
            transaction.commit();
        }
    }
    private void changeFragment(int from, int to) {
        if (from != to) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(fragments.get(from));
            if (!fragments.get(to).isAdded()) {
                transaction.add(R.id.vp_content, fragments.get(to),"fragment"+to);
            }
            transaction.show(fragments.get(to));
            transaction.commit();
            lastItemSelected = to;
        }
    }
    /*
     * 返回键退出应用
     * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if ((System.currentTimeMillis() - exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
