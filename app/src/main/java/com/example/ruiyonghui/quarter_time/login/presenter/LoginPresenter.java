package com.example.ruiyonghui.quarter_time.login.presenter;


import com.example.ruiyonghui.quarter_time.bean.LoginBean;
import com.example.ruiyonghui.quarter_time.login.contract.LoginContract;
import com.example.ruiyonghui.quarter_time.net.LoginApi;
import com.example.ruiyonghui.quarter_time.ui.base.BasePrensenter;


import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePrensenter<LoginContract.View> implements LoginContract.Presenter {
    private LoginApi loginApi;
    @Inject
    public LoginPresenter(LoginApi loginApi) {
        this.loginApi = loginApi;
    }
    @Override
    public void login(String mobile, String password) {

        loginApi.login(mobile, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        mView.loginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
