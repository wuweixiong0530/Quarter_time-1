package com.example.ruiyonghui.quarter_time.component;

import com.example.ruiyonghui.quarter_time.fragment.DuanZiFragment;
import com.example.ruiyonghui.quarter_time.fragment.RecommendFragment;
import com.example.ruiyonghui.quarter_time.fragment.VideoFragment;
import com.example.ruiyonghui.quarter_time.module.HttpModule;
import com.example.ruiyonghui.quarter_time.ui.collect.CollectActivity;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(CollectActivity collectActivity);
////    void inject(HomeActivity homeActivity);
//    void inject(RecommendFragment recommendFragment);
//    void inject(DuanZiFragment duanZiFragment);
//    void inject(VideoFragment videoFragment);
}
