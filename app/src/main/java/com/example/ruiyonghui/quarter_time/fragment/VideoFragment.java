package com.example.ruiyonghui.quarter_time.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.ui.recommend.fragment.GuanZhuFragment;
import com.example.ruiyonghui.quarter_time.ui.recommend.fragment.ReMenFragment;
import com.example.ruiyonghui.quarter_time.ui.video.VideoOneFragment;
import com.example.ruiyonghui.quarter_time.ui.video.VideoTwoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VideoFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.radio1)
    RadioButton radio1;
    @BindView(R.id.radio2)
    RadioButton radio2;
    @BindView(R.id.radioGrooup)
    RadioGroup radioGrooup;
    @BindView(R.id.fl)
    FrameLayout fl;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ///引入布局
        View view = inflater.inflate(R.layout.videofragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        radioGrooup.setOnCheckedChangeListener(this);
        radioGrooup.check(R.id.radio1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio1:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl,new VideoOneFragment()).commit();
                radio1.setTextColor(Color.BLUE);
                radio2.setTextColor(Color.BLACK);
                break;
            case R.id.radio2:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl,new VideoTwoFragment()).commit();
                radio1.setTextColor(Color.BLACK);
                radio2.setTextColor(Color.BLUE);
                break;
            default:
                break;
        }
    }
}