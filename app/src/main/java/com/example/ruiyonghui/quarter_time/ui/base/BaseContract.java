package com.example.ruiyonghui.quarter_time.ui.base;

public interface BaseContract {
    interface BasePresenter<T extends BaseView>{
         void attchView(T view);
    }

    interface BaseView{
        void showLoding();
        void dismissLoding();

    }
}
