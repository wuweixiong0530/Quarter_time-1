package com.example.ruiyonghui.quarter_time.ui.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;
import com.example.ruiyonghui.quarter_time.component.DaggerHttpComponent;
import com.example.ruiyonghui.quarter_time.module.HttpModule;
import com.example.ruiyonghui.quarter_time.ui.base.BaseFragment;
import com.example.ruiyonghui.quarter_time.ui.video.adapter.VideoAdapter;

/**
 * Created by wwx on 2018/6/7,0007.
 */

public class VideoOneFragment extends BaseFragment<VideoOnePresenter> implements VideoOneContract.View {

    private RecyclerView recyclerView;
    String token = "36471BDA7A4BD22560CC9A207185CA65";
    int page = 1;

    @Override
    public int getContentLayout() {

        return R.layout.video_layout;
    }

    @Override
    public void initView(View view) {
        Toast.makeText(getActivity(), "进来了啦啦啦啦啦啦绿绿", Toast.LENGTH_SHORT).show();
        recyclerView = view.findViewById(R.id.recycleView_video);
        mPresenter.getVideoOne(token, String.valueOf(page));
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);

    }

    @Override
    public void getVideoSuccess(HotVideoBean hotVideoBean) {
        Toast.makeText(getActivity(), "成功" + hotVideoBean.getMsg(), Toast.LENGTH_SHORT).show();
        if (hotVideoBean.getCode().equals("0")) {
            VideoAdapter adapter = new VideoAdapter(getActivity(), hotVideoBean);
//            recyclerView.setHasFixedSize(true);
//            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);

        }
    }

    @Override
    public void getVideoError(Throwable e) {
        Toast.makeText(getActivity(), "失败" + e, Toast.LENGTH_SHORT).show();
    }

}
