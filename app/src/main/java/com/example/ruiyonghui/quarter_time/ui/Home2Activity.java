package com.example.ruiyonghui.quarter_time.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.fragment.DuanZiFragment;
import com.example.ruiyonghui.quarter_time.fragment.RecommendFragment;
import com.example.ruiyonghui.quarter_time.fragment.VideoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home2Activity extends AppCompatActivity {

    @BindView(R.id.bottomTabBar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        ButterKnife.bind(this);

        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("推荐", R.mipmap.ic_launcher, RecommendFragment.class)
                .addTabItem("段子", R.mipmap.ic_launcher, DuanZiFragment.class)
                .addTabItem("视频", R.mipmap.ic_launcher, VideoFragment.class);
    }
}
