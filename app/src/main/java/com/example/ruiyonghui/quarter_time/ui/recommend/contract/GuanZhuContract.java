package com.example.ruiyonghui.quarter_time.ui.recommend.contract;

import com.example.ruiyonghui.quarter_time.bean.GuanZhuBean;
import com.example.ruiyonghui.quarter_time.ui.base.BaseContract;

/**
 * Created by wwx on 2018/6/6,0006.
 */

public interface GuanZhuContract {
    interface View extends BaseContract.BaseView {
       void getGuanZhu(GuanZhuBean guanZhuBean);
       void getGuanZhu(Throwable e);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getGuanZhu(String token,String uid);

    }
}
