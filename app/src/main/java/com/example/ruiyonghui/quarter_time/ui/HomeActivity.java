package com.example.ruiyonghui.quarter_time.ui;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.fragment.DuanZiFragment;
import com.example.ruiyonghui.quarter_time.fragment.RecommendFragment;
import com.example.ruiyonghui.quarter_time.fragment.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottom_tab_bar;
    @BindView(R.id.touxiang)
    ImageView touxiang;
    @BindView(R.id.edit_query)
    ImageView edit_query;
    @BindView(R.id.main_Drawer)
    DrawerLayout main_Drawer;
    @BindView(R.id.main_rigt)
    LinearLayout main_rigt;
    @BindView(R.id.main_text_biaoti)
    TextView main_text_biaoti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );
        ButterKnife.bind(this);

        main_Drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        bottom_tab_bar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(8)
               // .setTabPadding(4, 6, 10)
                .setChangeColor(Color.BLUE, Color.DKGRAY)
                .addTabItem("推荐", R.drawable.raw_1500085367, RecommendFragment.class)
                .addTabItem("段子", R.drawable.raw_1500085327, DuanZiFragment.class)
                .addTabItem("视频", R.drawable.raw_1500083686, VideoFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        main_text_biaoti.setText(name);
                    }
                });


    }
    @OnClick({R.id.touxiang, R.id.edit_query})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.touxiang:
                // TODO 点击按钮打开侧滑菜单
                if (!main_Drawer.isDrawerOpen(main_rigt)) {
                    main_Drawer.openDrawer(main_rigt);
                }
                break;
            case R.id.edit_query:
                break;
        }
    }


}
