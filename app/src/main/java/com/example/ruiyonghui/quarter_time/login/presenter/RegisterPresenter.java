package com.example.ruiyonghui.quarter_time.login.presenter;



import com.example.ruiyonghui.quarter_time.bean.RegisterBean;
import com.example.ruiyonghui.quarter_time.login.contract.RegisterContract;
import com.example.ruiyonghui.quarter_time.net.RegisterApi;
import com.example.ruiyonghui.quarter_time.ui.base.BasePrensenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter extends BasePrensenter<RegisterContract.View> implements RegisterContract.Presenter{
    RegisterApi registerApi;
    @Inject
    public RegisterPresenter(RegisterApi registerApi) {
        this.registerApi = registerApi;
    }

    @Override
    public void register(String mobile, String password) {
        registerApi.register(mobile, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        mView.registerSuccess(registerBean);
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
