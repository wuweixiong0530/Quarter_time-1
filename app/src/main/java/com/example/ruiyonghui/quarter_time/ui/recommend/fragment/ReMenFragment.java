package com.example.ruiyonghui.quarter_time.ui.recommend.fragment;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
import com.example.ruiyonghui.quarter_time.ui.recommend.adapter.HotVideoAdapter;
import com.example.ruiyonghui.quarter_time.ui.recommend.presenter.ReMenPresenter;
import com.example.ruiyonghui.quarter_time.untils.ObservableScrollView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wwx on 2018/6/5,0005.
 */

public class ReMenFragment extends BaseFragment<ReMenPresenter> implements ReMenContract.View {
    XBanner xBanner;
    RecyclerView recycleViewRemen;

    String token = "36471BDA7A4BD22560CC9A207185CA65";
    int page = 1;
    private SmartRefreshLayout smartRefreshLayout;
    private ObservableScrollView observableScrollView;

    @Override
    public int getContentLayout() {
        return R.layout.remen_fragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {
        observableScrollView = view.findViewById(R.id.observe_scroll_view);
        smartRefreshLayout = view.findViewById(R.id.sm);
        xBanner = view.findViewById(R.id.xBanner);
        recycleViewRemen = view.findViewById(R.id.recycleView_remen);
        mPresenter.getLunBo();
        mPresenter.getHotVideo(token, String.valueOf(page));

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                page++;
                mPresenter.getHotVideo(token, String.valueOf(page));
                smartRefreshLayout.finishRefresh(2000);
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                mPresenter.getHotVideo(token, String.valueOf(page));
                smartRefreshLayout.finishLoadMore(2000);
            }
        });
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
     *
     * @param hotVideoBean
     */
    @Override
    public void getHotVideoSuccess(HotVideoBean hotVideoBean) {

        Toast.makeText(getActivity(), "成功" + hotVideoBean.getMsg(), Toast.LENGTH_SHORT).show();
        if (hotVideoBean.getCode().equals("0")) {
            HotVideoAdapter hotVideoAdapter = new HotVideoAdapter(getActivity(), hotVideoBean);
            recycleViewRemen.setAdapter(hotVideoAdapter);
            recycleViewRemen.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    /**
     * 获取热门视频列表失败
     *
     * @param e
     */
    @Override
    public void getHotVideoError(Throwable e) {
        Toast.makeText(getActivity(), "失败" + e, Toast.LENGTH_SHORT).show();

    }

}
