package com.example.ruiyonghui.quarter_time.component;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.ruiyonghui.quarter_time.fragment.DuanZiFragment;
import com.example.ruiyonghui.quarter_time.login.LoginActivity;
import com.example.ruiyonghui.quarter_time.login.RegistActivity;
import com.example.ruiyonghui.quarter_time.module.HttpModule;
import com.example.ruiyonghui.quarter_time.ui.collect.CollectActivity;
import com.example.ruiyonghui.quarter_time.ui.followusers.FollowUsersActivity;
import com.example.ruiyonghui.quarter_time.ui.recommend.fragment.GuanZhuFragment;
import com.example.ruiyonghui.quarter_time.ui.recommend.fragment.ReMenFragment;
import com.example.ruiyonghui.quarter_time.ui.video.VideoOneFragment;

import dagger.Component;


@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(CollectActivity collectActivity);

    ////    void inject(HomeActivity homeActivity);
//    void inject(RecommendFragment recommendFragment);
//    void inject(VideoFragment videoFragment);
    void inject(LoginActivity loginActivity);
    void inject(DuanZiFragment duanziFragment);
    void inject(RegistActivity registActivity);
    void inject(FollowUsersActivity followUsersActivity);
    void inject(ReMenFragment reMenFragment);

    void inject(GuanZhuFragment guanZhuFragment);

    void inject(FragmentActivity activity);

    void inject(VideoOneFragment videoOneFragment);
}
