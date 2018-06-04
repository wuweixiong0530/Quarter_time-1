package com.example.ruiyonghui.quarter_time.ui;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
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

    @BindView(R.id.takecare)
    TextView takecare;
    @BindView(R.id.collection)
    TextView collection;
    @BindView(R.id.friend)
    TextView friend;
    @BindView(R.id.messages)
    TextView messages;
    @BindView(R.id.my_image_view)
    SimpleDraweeView myImageView;
    @BindView(R.id.night)
    TextView night;
    @BindView(R.id.my_directory)
    TextView myDirectory;
    @BindView(R.id.settings)
    TextView settings;
    @BindView(R.id.touxiang)
    SimpleDraweeView touxiang;
    @BindView(R.id.edit)
    ImageView edit;
    @BindView(R.id.bottomtabbar)
    BottomTabBar mBottomtabbar;
    private SlidingMenu menu;
    /**
     * 推荐
     */
    private TextView mHomeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();


        mBottomtabbar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("推荐", R.drawable.raw_1500085367, RecommendFragment.class)
                .addTabItem("段子", R.drawable.raw_1500085327, DuanZiFragment.class)
                .addTabItem("视频", R.drawable.raw_1500083686, VideoFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {
                        mHomeText.setText(name);
                    }

                });


        //new出SlidingMenu对象
        menu = new SlidingMenu(this);
        //设置侧滑的方向.左侧
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        // 设置滑动完剩余的宽度
        menu.setBehindOffset(210);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //绑定
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.sliding_left);

        ButterKnife.bind(this);
        //设置侧滑页面的头像展示
        Uri uri = Uri.parse("https://imgsa.baidu.com/forum/pic/item/3bc79f3df8dcd1000ac6c4fa798b4710b8122f96.jpg");
        SimpleDraweeView imageTouXiang = (SimpleDraweeView) findViewById(R.id.my_image_view);
        imageTouXiang.setImageURI(uri);


        //侧滑页面底部我的作品图标
        Drawable drawable_directory = getResources().getDrawable(R.drawable.raw_1499947056);
        drawable_directory.setBounds(0, 0, 40, 40);//40,40为宽高
        myDirectory.setCompoundDrawables(null, drawable_directory, null, null);
        //侧滑页面底部设置的图标
        Drawable drawable_settings = getResources().getDrawable(R.drawable.raw_1499947157);
        drawable_settings.setBounds(0, 0, 40, 40);//40,40为宽高
        settings.setCompoundDrawables(null, drawable_settings, null, null);
        //设置夜间模式左面的月亮
        Drawable drawable_night_colse = getResources().getDrawable(R.drawable.yl);
        drawable_night_colse.setBounds(0, 0, 35, 35);//40,40为宽高
        night.setCompoundDrawables(drawable_night_colse, null, null, null);
        //设置文字右侧的图片
        Drawable drawable_sliding_xiangyoua = getResources().getDrawable(R.drawable.raw_1499943790);
        drawable_sliding_xiangyoua.setBounds(0, 0, 33, 33);//40,40为宽高
        //设置textview的drawableleft大小
        Drawable drawable_my_takecare = getResources().getDrawable(R.drawable.my_takecare);
        drawable_my_takecare.setBounds(0, 0, 40, 40);
        takecare.setCompoundDrawables(drawable_my_takecare, null, drawable_sliding_xiangyoua, null);
        Drawable drawable_my_collection = getResources().getDrawable(R.drawable.raw_1499947358);
        drawable_my_collection.setBounds(0, 0, 40, 40);
        collection.setCompoundDrawables(drawable_my_collection, null, drawable_sliding_xiangyoua, null);
        Drawable drawable_search_friend = getResources().getDrawable(R.drawable.raw_1499946865);
        drawable_search_friend.setBounds(0, 0, 40, 40);
        friend.setCompoundDrawables(drawable_search_friend, null, drawable_sliding_xiangyoua, null);
        Drawable drawable_messages = getResources().getDrawable(R.drawable.raw_1499947389);
        drawable_messages.setBounds(0, 0, 40, 40);
        messages.setCompoundDrawables(drawable_messages, null, drawable_sliding_xiangyoua, null);

    }

    /**
     * 点击事件
     */
    @OnClick({R.id.touxiang, R.id.edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.touxiang:
                menu.showMenu();
                break;
            case R.id.edit:
                break;
        }
    }

    private void initView() {
        mHomeText = (TextView) findViewById(R.id.home_text);
    }
}
