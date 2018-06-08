package com.example.ruiyonghui.quarter_time.ui.followusers.presenter;

import com.example.ruiyonghui.quarter_time.bean.FavoritesBean;
import com.example.ruiyonghui.quarter_time.bean.FollowUsersBean;
import com.example.ruiyonghui.quarter_time.net.CollectApi;
import com.example.ruiyonghui.quarter_time.net.FollowUsersApi;
import com.example.ruiyonghui.quarter_time.ui.base.BasePrensenter;
import com.example.ruiyonghui.quarter_time.ui.collect.contract.CollectContract;
import com.example.ruiyonghui.quarter_time.ui.followusers.contract.FollowUsersContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wwx on 2018/6/5,0005.
 */

public class FollowUsersPresenter extends BasePrensenter<FollowUsersContract.View> implements FollowUsersContract.Presenter{

    FollowUsersApi followUsersApi;
    @Inject
    public FollowUsersPresenter(FollowUsersApi followUsersApi) {
        this.followUsersApi = followUsersApi;
    }
    @Override
    public void getFollowUsers(String uid, String token) {
        followUsersApi.getFollowUsers( uid, token )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( new Observer<FollowUsersBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FollowUsersBean followUsersBean) {
                        mView.getFollowUsersSuccess( followUsersBean );

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.getFollowUsersError( e );
                    }

                    @Override
                    public void onComplete() {

                    }
                } );


    }
}
