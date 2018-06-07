package com.example.ruiyonghui.quarter_time.ui.recommend.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.GuanZhuBean;
import com.example.ruiyonghui.quarter_time.component.DaggerHttpComponent;
import com.example.ruiyonghui.quarter_time.module.HttpModule;
import com.example.ruiyonghui.quarter_time.ui.base.BaseFragment;
import com.example.ruiyonghui.quarter_time.ui.recommend.adapter.GuanZhuAdapter;
import com.example.ruiyonghui.quarter_time.ui.recommend.adapter.HotVideoAdapter;
import com.example.ruiyonghui.quarter_time.ui.recommend.contract.GuanZhuContract;
import com.example.ruiyonghui.quarter_time.ui.recommend.presenter.GuanZhuPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by wwx on 2018/6/5,0005.
 */

public class GuanZhuFragment extends BaseFragment<GuanZhuPresenter> implements GuanZhuContract.View {

    private RecyclerView recyclerView;
    private static final String TAG = "GuanZhuFragment";
    private SimpleDraweeView simpleDraweeView;

    @Override
    public int getContentLayout() {
        return R.layout.guanzhu_fragment;
    }

    @Override
    public void initView(View view) {
        simpleDraweeView = view.findViewById(R.id.gaoxiao_img);
        recyclerView = view.findViewById(R.id.recycleView_guanzhu);

        simpleDraweeView.setImageURI(String.valueOf(R.drawable.gaoxiao));

        mPresenter.attchView(this);
        mPresenter.getGuanZhu("36471BDA7A4BD22560CC9A207185CA65","2845");
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    /**
     * 重写成功
     * @param guanZhuBean
     */
    @Override
    public void getGuanZhu(GuanZhuBean guanZhuBean) {
        Log.i(TAG, "getGuanZhu: 成功"+guanZhuBean.getMsg());
        if (guanZhuBean.getCode().equals("0")){
            GuanZhuAdapter guanZhuAdapter = new GuanZhuAdapter(getActivity(), guanZhuBean);
            recyclerView.setAdapter(guanZhuAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        }
    }

    /**
     * 失败
     * @param e
     */
    @Override
    public void getGuanZhu(Throwable e) {
        Log.i(TAG, "getGuanZhu: 失败原因"+e);
    }
}
