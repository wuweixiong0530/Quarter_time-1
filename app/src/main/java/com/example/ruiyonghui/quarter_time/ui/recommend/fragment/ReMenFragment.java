package com.example.ruiyonghui.quarter_time.ui.recommend.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.AdvertiseBean;
import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;
import com.example.ruiyonghui.quarter_time.component.DaggerHttpComponent;
import com.example.ruiyonghui.quarter_time.module.HttpModule;
import com.example.ruiyonghui.quarter_time.ui.base.BaseFragment;
import com.example.ruiyonghui.quarter_time.ui.recommend.contract.ReMenContract;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wwx on 2018/6/5,0005.
 */

public class ReMenFragment extends BaseFragment<ReMenContract.Presenter> implements ReMenContract.View {

    @BindView(R.id.xBanner)
    XBanner xBanner;
    @BindView(R.id.recycleView_remen)
    RecyclerView recycleViewRemen;
    Unbinder unbinder;
    private View view;

    String token = "36471BDA7A4BD22560CC9A207185CA65";
    String source = "android";
    int page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), getContentLayout(), null);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        mPresenter.attchView(this);
//        mPresenter.getLunBo();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public int getContentLayout() {
        return R.layout.remen_fragment;
    }

    @Override
    public void initView(View view) {
        mPresenter.attchView(this);

        mPresenter.getLunBo();

        mPresenter.getHotVideo(token,source, String.valueOf(page));
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(getActivity());

    }

    /**
     * 轮播成功
     *
     * @param advertiseBean
     */
    @Override
    public void getLunBoSuccess(AdvertiseBean advertiseBean) {
        Toast.makeText(getActivity(), "成功是" + advertiseBean.getMsg(), Toast.LENGTH_SHORT).show();
        if (advertiseBean.getCode().equals("0")) {
            final List<String> imgList = new ArrayList<>();
            List<AdvertiseBean.DataBean> imgData = advertiseBean.getData();
            for (AdvertiseBean.DataBean dataBean : imgData) {
                String icon = dataBean.getIcon();
                imgList.add(icon);
            }

            xBanner.setData(imgList, null);
            xBanner.setPoinstPosition(XBanner.BOTTOM);
            xBanner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(getActivity()).load(imgList.get(position)).into((ImageView) view);
                }
            });
        }
    }

    /**
     * 轮播失败
     *
     * @param throwable
     */
    @Override
    public void getLunBoError(Throwable throwable) {
        Toast.makeText(getActivity(), "错误是" + throwable, Toast.LENGTH_SHORT).show();

    }

    /**
     * 获取热门视频列表成功
     * @param hotVideoBean
     */
    @Override
    public void getHotVideoSuccess(HotVideoBean hotVideoBean) {
//        Toast.makeText(getActivity(),"成功"+hotVideoBean.getMsg(),Toast.LENGTH_SHORT).show();
//        if (hotVideoBean.getCode().equals)
    }

    /**
     * 获取热门视频列表失败
     * @param e
     */
    @Override
    public void getHotVideoError(Throwable e) {
        Toast.makeText(getActivity(),"失败"+e,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mPresenter.detachView();
    }
}
