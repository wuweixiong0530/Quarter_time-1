package com.example.ruiyonghui.quarter_time.login.contract;


import com.example.ruiyonghui.quarter_time.bean.LoginBean;
import com.example.ruiyonghui.quarter_time.ui.base.BaseContract;

public interface LoginContract {
    interface View extends BaseContract.BaseView {
        void loginSuccess(LoginBean loginBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void login(String mobile, String password);
    }
}
