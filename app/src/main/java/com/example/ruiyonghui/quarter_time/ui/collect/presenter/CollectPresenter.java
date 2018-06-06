package com.example.ruiyonghui.quarter_time.ui.collect.presenter;

import com.example.ruiyonghui.quarter_time.bean.FavoritesBean;
import com.example.ruiyonghui.quarter_time.net.CollectApi;
import com.example.ruiyonghui.quarter_time.ui.base.BasePrensenter;
import com.example.ruiyonghui.quarter_time.ui.collect.contract.CollectContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wwx on 2018/6/5,0005.
 */

public class CollectPresenter extends BasePrensenter<CollectContract.View> implements CollectContract.Presenter{

    private CollectApi collectApi;

    @Inject
    public CollectPresenter(CollectApi collectApi){
        this.collectApi = collectApi;
    }
    @Override
    public void getFavorites(String uid, String token, String source, String appVersion) {
        collectApi.getFavorites(uid,token,source,appVersion)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FavoritesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FavoritesBean favoritesBean) {
                        mView.getFavorSuccess(favoritesBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.getFavorError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
