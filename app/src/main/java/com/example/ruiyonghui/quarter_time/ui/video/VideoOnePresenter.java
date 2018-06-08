package com.example.ruiyonghui.quarter_time.ui.video;

import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;
import com.example.ruiyonghui.quarter_time.net.VideoOneApi;
import com.example.ruiyonghui.quarter_time.ui.base.BasePrensenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wwx on 2018/6/8,0008.
 */

public class VideoOnePresenter extends BasePrensenter<VideoOneContract.View> implements VideoOneContract.Presenter {

    private VideoOneApi videoOneApi;

    @Inject
    public VideoOnePresenter(VideoOneApi videoOneApi){
        this.videoOneApi = videoOneApi;
    }

    @Override
    public void getVideoOne(String token, String page) {
        videoOneApi.getVideoOne(token,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotVideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotVideoBean hotVideoBean) {
                        if (mView != null){
                            mView.getVideoSuccess(hotVideoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.getVideoError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
