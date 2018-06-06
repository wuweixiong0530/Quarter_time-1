package com.example.ruiyonghui.quarter_time.ui.recommend.contract;

import com.example.ruiyonghui.quarter_time.bean.AdvertiseBean;
import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;
import com.example.ruiyonghui.quarter_time.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/6/5,0005.
 * 热门
 */

public interface ReMenContract {
    interface View extends BaseContract.BaseView {
        void getLunBoSuccess(AdvertiseBean advertiseBean);
        void getLunBoError(Throwable e);

        void getHotVideoSuccess(HotVideoBean hotVideoBean);
        void getHotVideoError(Throwable e);
    }

    interface Presenter extends BaseContract.BasePresenter<ReMenContract.View> {
        //获取轮播
        void getLunBo();

        void getHotVideo(String token,String source,String page);

    }
}
