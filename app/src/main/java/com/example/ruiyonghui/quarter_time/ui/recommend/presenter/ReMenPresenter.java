package com.example.ruiyonghui.quarter_time.ui.recommend.presenter;

import android.util.Log;

import com.example.ruiyonghui.quarter_time.bean.AdvertiseBean;
import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;
import com.example.ruiyonghui.quarter_time.net.HtoVideoApi;
import com.example.ruiyonghui.quarter_time.net.ReMenApi;
import com.example.ruiyonghui.quarter_time.ui.base.BasePrensenter;
import com.example.ruiyonghui.quarter_time.ui.recommend.contract.ReMenContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/6/5,0005.
 */

public class ReMenPresenter extends BasePrensenter<ReMenContract.View> implements ReMenContract.Presenter {

    public ReMenApi reMenApi;
    public HtoVideoApi htoVideoApi;

    @Inject
    public ReMenPresenter(ReMenApi reMenApi, HtoVideoApi htoVideoApi) {
        this.reMenApi = reMenApi;
        this.htoVideoApi = htoVideoApi;
    }

    @Override
    public void getLunBo() {
        reMenApi.getReMen()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AdvertiseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdvertiseBean advertiseBean) {
                        if (mView!=null) {
                            mView.getLunBoSuccess(advertiseBean);
                            Log.i("ppppp", "数据" + advertiseBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.getLunBoError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getHotVideo(String token,String page) {
        htoVideoApi.getHotVideo(token,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotVideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotVideoBean hotVideoBean) {
                        if (mView != null){
                            mView.getHotVideoSuccess(hotVideoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.getHotVideoError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
