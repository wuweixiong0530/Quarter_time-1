package com.example.ruiyonghui.quarter_time.fragment;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.component.DaggerHttpComponent;
import com.example.ruiyonghui.quarter_time.ui.base.BaseFragment;
import com.example.ruiyonghui.quarter_time.bean.DuanziBean;
import com.example.ruiyonghui.quarter_time.ui.duanzi.contract.DuanziContract;
import com.example.ruiyonghui.quarter_time.ui.duanzi.adapter.DuanziMyAdapter;

import com.example.ruiyonghui.quarter_time.ui.duanzi.adapter.OnItemClickListener;
import com.example.ruiyonghui.quarter_time.ui.duanzi.presenter.DuanziPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.umeng.socialize.UMShareAPI;

import java.util.List;

public class DuanZiFragment extends BaseFragment<DuanziPresenter> implements DuanziContract.View {
    private RecyclerView xlv;
    private int page = 10;
    @Override
    public int getContentLayout() {
        return  R.layout.duanzifragment;
    }

    @Override
    public void initView(View view) {
        xlv = view.findViewById(R.id.xrl);
        SmartRefreshLayout smar = view.findViewById(R.id.refreshLayout);
        mPresenter.getDuanzi(page + "");

        smar.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page = page + 1;
                mPresenter.getDuanzi(page + "");
                refreshLayout.finishLoadMore(2000);
                Log.d("DuanziFragment", "page:" + page);
            }
        });
        smar.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                page = page + 1;
                mPresenter.getDuanzi(page + "");
                refreshLayout.finishRefresh(2000);

                Log.d("DuanziFragment", "page:" + page);
            }
        });
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void onSuccess(List<DuanziBean.DataBean> list) {
        DuanziMyAdapter duanziAdapter = new DuanziMyAdapter(getActivity(), list);
        xlv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        xlv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        xlv.setAdapter(duanziAdapter);
        duanziAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(int position, String name) {
                if (name.equals("点赞")) {
                    //  Toast.makeText(getActivity(), "position:" + position + "dianzan ", Toast.LENGTH_SHORT).show();
                    //+token值
                    mPresenter.getdianzan("2845", position + "","36471BDA7A4BD22560CC9A207185CA65");
                }
                if (name.equals("评论")) {
                    //      Toast.makeText(getActivity(), "position:" + position + "pinglun ", Toast.LENGTH_SHORT).show();

                    mPresenter.getpinglun("2845", position + "","36471BDA7A4BD22560CC9A207185CA65");
                }
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onSuccessa(String bean) {
        Toast.makeText(getActivity(), bean.toString(), Toast.LENGTH_SHORT).show();
        Log.d("DuanziFragment", "点赞成功");
    }

    @Override
    public void onSuccessb(String bean) {
        Toast.makeText(getActivity(), bean, Toast.LENGTH_SHORT).show();
        Log.d("DuanziFragment", "评论成功");
    }
}
