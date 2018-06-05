package com.example.ruiyonghui.quarter_time.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.login.LoginHomeActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class RecommendFragment extends Fragment implements View.OnClickListener {
    SimpleDraweeView touxiang;
    TextView homeText;
    ImageView edit;
    SlidingMenu menu;
    /**
     * 推荐
     */
    View view;
    SimpleDraweeView imageTouXiang;
    private RelativeLayout my_attention;
    private RelativeLayout my_collect;
    private RelativeLayout search_friend;
    private RelativeLayout info_message;
    private RelativeLayout night_mode;
    private RelativeLayout my_works;
    private RelativeLayout setting;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ///引入布局
        view = inflater.inflate(R.layout.recommend, container, false);
        touxiang = view.findViewById(R.id.touxiang);
        homeText = view.findViewById(R.id.home_text);
        edit = view.findViewById(R.id.edit);
        touxiang.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        menu = new SlidingMenu(getActivity());
        //设置侧滑的方向.左侧
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置滑动完剩余的宽度
        menu.setBehindOffset(210);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //绑定
        menu.attachToActivity(getActivity(), SlidingMenu.SLIDING_WINDOW);
        //为侧滑菜单设置布局
        View leftView = View.inflate(getContext(), R.layout.sliding_left, null);
        menu.setMenu(leftView);
        //设置侧滑页面的头像展示
        imageTouXiang = leftView.findViewById(R.id.my_image_view);
        my_attention = leftView.findViewById(R.id.my_attention);//关注
        my_collect = leftView.findViewById(R.id.my_collect);//收藏
        search_friend = leftView.findViewById(R.id.search_friend);//搜索好友
        info_message = leftView.findViewById(R.id.info_message);//消息通知
        night_mode = leftView.findViewById(R.id.night_mode);//夜间模式
        my_works = leftView.findViewById(R.id.my_works);//我的作品
        setting = leftView.findViewById(R.id.setting);//设置
        imageTouXiang.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),LoginHomeActivity.class);
                startActivity(intent  );
            }
        } );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.touxiang:
                menu.showMenu();
                break;
//            case R.id.my_image_view:
//
//                break;
            case R.id.edit:
                break;
        }
    }
}
