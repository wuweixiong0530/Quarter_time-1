package com.example.ruiyonghui.quarter_time.ui.video;

import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;
import com.example.ruiyonghui.quarter_time.ui.base.BaseContract;

/**
 * Created by wwx on 2018/6/8,0008.
 */

public interface VideoOneContract {
    interface View extends BaseContract.BaseView{
        void getVideoSuccess(HotVideoBean hotVideoBean);
        void getVideoError(Throwable e);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getVideoOne(String token,String page);
    }
}
