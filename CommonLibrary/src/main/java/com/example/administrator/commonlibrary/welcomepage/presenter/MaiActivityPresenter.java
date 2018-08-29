package com.example.administrator.commonlibrary.welcomepage.presenter;



import android.util.Log;


import com.example.administrator.commonlibrary.bese.BasePresenterImpl;
import com.example.administrator.commonlibrary.contract.activity.MaiAcivityContract;

import java.util.ArrayList;
import java.util.List;

public class MaiActivityPresenter extends BasePresenterImpl<MaiAcivityContract.View> implements MaiAcivityContract.Presenter {
    private List<String> listPath=new ArrayList<>();
    @Override
    protected void attachView() {

    }

    public void addFragmentPath(){
        listPath.add("com.example.onepagelibrary");
        listPath.add("com.example.twopagelibrary");
        listPath.add("com.example.threepagelibrary");
        listPath.add("com.example.fourpagelibrary");
        listPath.add("com.example.fivepagelibrary");
    }

    public List<String> getFragmentPath(){
        addFragmentPath();
        Log.d("TAG",listPath.size()+"listPath--");
        return listPath;
    }
}
