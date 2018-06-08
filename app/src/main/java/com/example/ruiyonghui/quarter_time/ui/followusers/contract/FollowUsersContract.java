package com.example.ruiyonghui.quarter_time.ui.followusers.contract;

import com.example.ruiyonghui.quarter_time.bean.FavoritesBean;
import com.example.ruiyonghui.quarter_time.bean.FollowUsersBean;
import com.example.ruiyonghui.quarter_time.bean.GuanZhuBean;
import com.example.ruiyonghui.quarter_time.ui.base.BaseContract;

/**
 * Created by wwx on 2018/6/5,0005.
 */

public interface FollowUsersContract {
    interface View extends BaseContract.BaseView {
        void getFollowUsersSuccess(FollowUsersBean followUsersBean);
        void getFollowUsersError(Throwable throwable);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        //获取收藏
        void getFollowUsers(String uid, String token);

    }
}
