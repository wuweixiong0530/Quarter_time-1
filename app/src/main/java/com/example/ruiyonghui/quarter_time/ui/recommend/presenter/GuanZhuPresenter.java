package com.example.ruiyonghui.quarter_time.ui.recommend.presenter;

import com.example.ruiyonghui.quarter_time.bean.GuanZhuBean;
import com.example.ruiyonghui.quarter_time.net.GuanZhuApi;
import com.example.ruiyonghui.quarter_time.net.GuanZhuService;
import com.example.ruiyonghui.quarter_time.ui.base.BasePrensenter;
import com.example.ruiyonghui.quarter_time.ui.recommend.contract.GuanZhuContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wwx on 2018/6/6,0006.
 */

public class GuanZhuPresenter extends BasePrensenter<GuanZhuContract.View> implements GuanZhuContract.Presenter {
    public GuanZhuApi guanZhuApi;

    @Inject
    public GuanZhuPresenter(GuanZhuApi guanZhuApi) {
        this.guanZhuApi = guanZhuApi;
    }

    @Override
    public void getGuanZhu(String token, String uid) {
        guanZhuApi.getGuanZhu(token, uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GuanZhuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GuanZhuBean guanZhuBean) {
                        if (mView != null){
                            mView.getGuanZhu(guanZhuBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.getGuanZhu(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
