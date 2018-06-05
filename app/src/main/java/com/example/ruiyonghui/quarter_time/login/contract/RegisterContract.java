package com.example.ruiyonghui.quarter_time.login.contract;

import com.example.ruiyonghui.quarter_time.bean.RegisterBean;
import com.example.ruiyonghui.quarter_time.ui.base.BaseContract;

public interface RegisterContract {
    interface View extends BaseContract.BaseView{
        void registerSuccess(RegisterBean registerBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void register(String mobile, String password);
    }
}
