package com.example.ruiyonghui.quarter_time.ui.collect;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.FavoritesBean;
import com.example.ruiyonghui.quarter_time.component.DaggerHttpComponent;
import com.example.ruiyonghui.quarter_time.module.HttpModule;
import com.example.ruiyonghui.quarter_time.ui.base.BaseActivity;
import com.example.ruiyonghui.quarter_time.ui.collect.adapter.CollectAdapter;
import com.example.ruiyonghui.quarter_time.ui.collect.contract.CollectContract;
import com.example.ruiyonghui.quarter_time.ui.collect.presenter.CollectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的收藏
 */
public class CollectActivity extends BaseActivity<CollectPresenter> implements CollectContract.View {

    @BindView(R.id.tv_back)
    TextView tv_back;
    @BindView(R.id.delete_collect)
    TextView deleteCollect;
    @BindView(R.id.recycleView_collect)
    RecyclerView recycleViewCollect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_collect);

        ButterKnife.bind(this);

        mPresenter.attchView(this);
        mPresenter.getFavorites("2845","36471BDA7A4BD22560CC9A207185CA65");
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * 重写BaseActivity方法
     * @return
     */
    @Override
    public int getContentLayout() {
        return R.layout.activity_collect;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    /**
     * 重写CollectContract
     * @param favoritesBean
     */
    @Override
    public void getFavorSuccess(FavoritesBean favoritesBean) {
        Log.i("collect","成功:"+favoritesBean.getMsg());
//        Toast.makeText(this, favoritesBean.getMsg(),Toast.LENGTH_SHORT).show();
        if (favoritesBean.getCode().equals("0")){
            CollectAdapter collectAdapter = new CollectAdapter(this,favoritesBean);
            recycleViewCollect.setAdapter(collectAdapter);
            recycleViewCollect.setLayoutManager(new LinearLayoutManager(this));

        }

    }

    @Override
    public void getFavorError(Throwable throwable) {
        Log.i("collect","错误:"+throwable);
//        Toast.makeText(this, "错误是"+throwable,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter == null){
            mPresenter.detachView();
        }
    }
}
