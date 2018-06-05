package com.example.ruiyonghui.quarter_time.net;


import com.example.ruiyonghui.quarter_time.bean.LoginBean;

import io.reactivex.Observable;

public class LoginApi {
    private static LoginApi loginApi;
    private LoginApiService loginApiService;

    private LoginApi(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;
    }

    public static LoginApi getLoginApi(LoginApiService loginApiService) {
        if (loginApi == null) {
            loginApi = new LoginApi(loginApiService);
        }
        return loginApi;
    }

    public Observable<LoginBean> login(String mobile, String password) {
        return loginApiService.login(mobile, password);
    }

}
