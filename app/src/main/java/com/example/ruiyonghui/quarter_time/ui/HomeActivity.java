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

/**
 * home主界面
 */
public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.bottomTabBar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(40, 40)//图片大小
                .addTabItem("推荐", R.drawable.raw_1500085367, RecommendFragment.class)
                .addTabItem("段子", R.drawable.raw_1500085327, DuanZiFragment.class)
                .addTabItem("视频", R.drawable.raw_1500083686, VideoFragment.class);
    }
}
