package com.example.ruiyonghui.quarter_time.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.fragment.DuanZiFragment;
import com.example.ruiyonghui.quarter_time.fragment.RecommendFragment;
import com.example.ruiyonghui.quarter_time.fragment.VideoFragment;
import com.example.ruiyonghui.quarter_time.ui.collect.CollectActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * home主界面
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    SimpleDraweeView touxiang;
    TextView homeText;
    ImageView edit;
    BottomTabBar bottomTabBar;

    SlidingMenu menu;
    private SimpleDraweeView imageTouXiang;
    private RelativeLayout my_attention;
    private RelativeLayout my_collect;
    private RelativeLayout search_friend;
    private RelativeLayout info_message;
    private RelativeLayout night_mode;
    private RelativeLayout my_works;
    private RelativeLayout setting;
    private View leftView;
    private LinearLayout ll_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        intiView();
        //点击头像弹出侧拉菜单
        touxiang.setOnClickListener(this);

        //bottombar的设置
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(40, 40)//图片大小
                .addTabItem("推荐", R.drawable.raw_1500085367, RecommendFragment.class)
                .addTabItem("段子", R.drawable.raw_1500085327, DuanZiFragment.class)
                .addTabItem("视频", R.drawable.raw_1500083686, VideoFragment.class);
    }
}
