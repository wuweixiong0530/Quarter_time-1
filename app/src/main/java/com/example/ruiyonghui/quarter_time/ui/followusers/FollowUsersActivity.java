package com.example.ruiyonghui.quarter_time.ui.followusers;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.FollowUsersBean;
import com.example.ruiyonghui.quarter_time.component.DaggerHttpComponent;
import com.example.ruiyonghui.quarter_time.module.HttpModule;
import com.example.ruiyonghui.quarter_time.ui.base.BaseActivity;
import com.example.ruiyonghui.quarter_time.ui.collect.adapter.CollectAdapter;
import com.example.ruiyonghui.quarter_time.ui.followusers.adapter.FollowAdapter;
import com.example.ruiyonghui.quarter_time.ui.followusers.contract.FollowUsersContract;
import com.example.ruiyonghui.quarter_time.ui.followusers.presenter.FollowUsersPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FollowUsersActivity extends BaseActivity<FollowUsersPresenter> implements FollowUsersContract.View {

    @BindView(R.id.back)
    TextView mBack;
    @BindView(R.id.delete_collect)
    TextView mDeleteCollect;
    @BindView(R.id.recycleView_collect)
    RecyclerView mRecycleViewCollect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
//        setContentView( R.layout.activity_follow_users );
        ButterKnife.bind( this );
        mPresenter.attchView(this);
        mPresenter.getFollowUsers("2845","36471BDA7A4BD22560CC9A207185CA65");
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_follow_users;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject( this );
    }

    @Override
    public void getFollowUsersSuccess(FollowUsersBean followUsersBean) {
        Log.i("collect","成功:"+followUsersBean.getMsg());
//        Toast.makeText(this, favoritesBean.getMsg(),Toast.LENGTH_SHORT).show();
        if (followUsersBean.getCode().equals("0")){
            FollowAdapter followAdapter = new FollowAdapter( FollowUsersActivity.this, followUsersBean );
            mRecycleViewCollect.setAdapter(followAdapter);
            mRecycleViewCollect.setLayoutManager(new LinearLayoutManager(FollowUsersActivity.this));
            mRecycleViewCollect.addItemDecoration(new DividerItemDecoration( this,DividerItemDecoration.VERTICAL ));
        }
    }

    @Override
    public void getFollowUsersError(Throwable throwable) {
        Log.i("collect","错误:"+throwable);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter == null){
            mPresenter.detachView();
        }
    }
    @OnClick({R.id.back, R.id.delete_collect, R.id.recycleView_collect})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.delete_collect:

                break;
            case R.id.recycleView_collect:

                break;
        }
    }
}
