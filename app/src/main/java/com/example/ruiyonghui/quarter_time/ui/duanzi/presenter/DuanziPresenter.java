package com.example.ruiyonghui.quarter_time.ui.duanzi.presenter;

import android.annotation.SuppressLint;

import com.example.ruiyonghui.quarter_time.bean.DianzanBean;
import com.example.ruiyonghui.quarter_time.bean.DuanziBean;
import com.example.ruiyonghui.quarter_time.bean.PinglunBean;
import com.example.ruiyonghui.quarter_time.net.DianzanApi;
import com.example.ruiyonghui.quarter_time.net.DuanziApi;
import com.example.ruiyonghui.quarter_time.net.PinglunApi;
import com.example.ruiyonghui.quarter_time.ui.base.BasePrensenter;

import com.example.ruiyonghui.quarter_time.ui.duanzi.contract.DuanziContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fxf on 2018.06.05.
 */

public class DuanziPresenter extends BasePrensenter<DuanziContract.View> implements
        DuanziContract.Presenter {
    private DuanziApi duanziApi;
    private DianzanApi dianzanApi;
    private PinglunApi pinglunApi;


    @Inject
    public DuanziPresenter(DuanziApi duanziApi, DianzanApi dianzanApi, PinglunApi pinglunApi) {
        this.duanziApi = duanziApi;
        this.dianzanApi = dianzanApi;
        this.pinglunApi = pinglunApi;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getDuanzi(String page) {
        duanziApi.getDuanzi(page)
                .subscribeOn(Schedulers.io())
                .map(new Function<DuanziBean, List<DuanziBean.DataBean>>() {
                    @Override
                    public List<DuanziBean.DataBean> apply(DuanziBean duanziBean) throws Exception {
                        return duanziBean.getData();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<DuanziBean.DataBean>>() {
                    @Override
                    public void accept(List<DuanziBean.DataBean> dataBeans) throws Exception {
                        mView.onSuccess(dataBeans);

                    }
                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void getdianzan(String uid, String jid,String token) {
        dianzanApi.getDianzan(uid, jid,token)
                .subscribeOn(Schedulers.io())
                .map(new Function<DianzanBean, Object>() {
                    @Override
                    public Object apply(DianzanBean duanziBean) throws Exception {
                        return duanziBean.getMsg();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        mView.onSuccessa(o.toString());
                    }
                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void getpinglun(String uid, String jid,String token) {
        pinglunApi.getpinglun(uid, jid,token)
                .subscribeOn(Schedulers.io())
                .map(new Function<PinglunBean, Object>() {
                    @Override
                    public Object apply(PinglunBean duanziBean) throws Exception {
                        return duanziBean.getMsg();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        mView.onSuccessb(o.toString());
                    }
                });
    }


}