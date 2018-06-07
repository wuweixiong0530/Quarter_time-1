package com.example.ruiyonghui.quarter_time.ui.base;

public interface BaseContract {
    //抽取presenter公共性
    interface BasePresenter<T extends BaseView> {
        void attchView(T view);

        void detachView();
    }

    //抽取所有View的共性，比如显示进度条和关闭进度
    interface BaseView {
        void showLoading();

        void dismissLoading();
    }
}
