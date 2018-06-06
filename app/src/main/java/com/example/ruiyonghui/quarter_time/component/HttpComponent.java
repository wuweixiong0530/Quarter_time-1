package com.example.ruiyonghui.quarter_time.component;

import android.support.v4.app.FragmentActivity;

import com.example.ruiyonghui.quarter_time.login.LoginActivity;
import com.example.ruiyonghui.quarter_time.login.RegistActivity;
import com.example.ruiyonghui.quarter_time.module.HttpModule;
import com.example.ruiyonghui.quarter_time.ui.collect.CollectActivity;
import com.example.ruiyonghui.quarter_time.ui.recommend.fragment.ReMenFragment;

import dagger.Component;


@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(CollectActivity collectActivity);

    ////    void inject(HomeActivity homeActivity);
//    void inject(RecommendFragment recommendFragment);
//    void inject(DuanZiFragment duanZiFragment);
//    void inject(VideoFragment videoFragment);
    void inject(LoginActivity loginActivity);

    void inject(RegistActivity registActivity);

//    void inject(ReMenFragment reMenFragment);

    void inject(FragmentActivity activity);
}
