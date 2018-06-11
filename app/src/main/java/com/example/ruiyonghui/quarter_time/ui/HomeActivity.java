package com.example.ruiyonghui.quarter_time.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.fragment.DuanZiFragment;
import com.example.ruiyonghui.quarter_time.login.LoginHomeActivity;
import com.example.ruiyonghui.quarter_time.ui.followusers.FollowUsersActivity;
import com.example.ruiyonghui.quarter_time.ui.recommend.RecommendFragment;
import com.example.ruiyonghui.quarter_time.fragment.VideoFragment;
import com.example.ruiyonghui.quarter_time.ui.collect.CollectActivity;
import com.example.ruiyonghui.quarter_time.untils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * home主界面
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "hhhhhhh";
    SimpleDraweeView touxiang;
    TextView homeText;
    TextView name;
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
                .setImgSize(50, 50)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.BLUE, Color.DKGRAY)
                .setImgSize(50, 50)//图片大小
                .addTabItem("推荐", R.drawable.tui_yes, R.drawable.tui_no, RecommendFragment.class)
                .addTabItem("段子", R.drawable.duanzi_yes, R.drawable.duanzi_no, DuanZiFragment.class)
                .addTabItem("视频", R.drawable.shipin_yes, R.drawable.shipin_no, VideoFragment.class)
                .isShowDivider(false);
        //侧拉设置
        slidMenu();

        bottomTabBar.setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
            @Override
            public void onTabChange(int position, String name) {
                if (name.equals("推荐")) {
                    homeText.setText("推荐");
                } else if (name.equals("段子")) {
                    homeText.setText("段子");
                } else if (name.equals("视频")) {
                    homeText.setText("视频");
                }
            }
        });
    }


    private void slidMenu() {
        menu = new SlidingMenu(this);
        //设置侧滑的方向.左侧
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        // 设置滑动完剩余的宽度
        menu.setBehindOffset(210);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //绑定
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        //为侧滑菜单设置布局
        leftView = View.inflate(this, R.layout.sliding_left, null);
        menu.setMenu(leftView);
        ll_login = leftView.findViewById(R.id.ll_login);
        imageTouXiang = leftView.findViewById(R.id.my_image_view);
        name = leftView.findViewById(R.id.name);
        my_attention = leftView.findViewById(R.id.my_attention);//关注
        my_collect = leftView.findViewById(R.id.my_collect);//收藏
        search_friend = leftView.findViewById(R.id.search_friend);//搜索好友
        info_message = leftView.findViewById(R.id.info_message);//消息通知
        night_mode = leftView.findViewById(R.id.night_mode);//夜间模式
        my_works = leftView.findViewById(R.id.my_works);//我的作品
        setting = leftView.findViewById(R.id.setting);//设置
        my_collect.setOnClickListener(this);
        ll_login.setOnClickListener(this);
        setting.setOnClickListener(this);
        my_attention.setOnClickListener(this);

        String uid = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "uid", "");
        String username = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "name", "");
        String iconurl = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "iconurl", "");
        if ("-1".equals(uid)) {

        } else {
            imageTouXiang.setImageURI(iconurl);
            name.setText(username);
        }
    }

    private void intiView() {
        touxiang = findViewById(R.id.touxiang);
        homeText = findViewById(R.id.home_text);
        edit = findViewById(R.id.edit);
        bottomTabBar = findViewById(R.id.bottomTabBar);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.touxiang:
                menu.showMenu();
                break;
            case R.id.edit:
                break;
            case R.id.ll_login:
                String uid = (String) SharedPreferencesUtils.getParam(HomeActivity.this, "uid", "");
                if (!TextUtils.isEmpty(uid)) {
                    Toast.makeText(HomeActivity.this, "登录过了", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, LoginHomeActivity.class));
                }
                break;
                //我的收藏
            case R.id.my_collect:
                startActivity(new Intent(this, CollectActivity.class));
                break;
            //侧拉我的关注
            case R.id.my_attention:
                startActivity(new Intent(this, FollowUsersActivity.class));
                break;
            //设置
            case R.id.setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;

        }
    }
}
