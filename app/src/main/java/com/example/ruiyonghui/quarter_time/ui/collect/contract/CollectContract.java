package com.example.ruiyonghui.quarter_time.ui.collect.contract;

import com.example.ruiyonghui.quarter_time.bean.FavoritesBean;
import com.example.ruiyonghui.quarter_time.ui.base.BaseContract;

import java.util.List;

/**
 * Created by wwx on 2018/6/5,0005.
 */

public interface CollectContract {
    interface View extends BaseContract.BaseView {
        void getFavorSuccess(FavoritesBean favoritesBean);
        void getFavorError(Throwable throwable);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        //获取收藏
        void getFavorites(String uid,String token);

    }
}
