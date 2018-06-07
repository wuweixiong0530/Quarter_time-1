package com.example.ruiyonghui.quarter_time.ui.collect.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.FavoritesBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/5,0005.
 * 收藏适配器
 */

public class CollectAdapter extends RecyclerView.Adapter<CollectAdapter.ViewHolder>{
    private Context context;
    private FavoritesBean favoritesBean;

    public CollectAdapter(Context context, FavoritesBean favoritesBean) {
        this.context = context;
        this.favoritesBean = favoritesBean;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        View view = View.inflate(context,R.layout.collect_item,null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<FavoritesBean.DataBean> list = favoritesBean.getData();
        holder.tv1.setText(list.get(position).getUser().getNickname());
        holder.tv2.setText(list.get(position).getCreateTime());
        holder.tv3.setText(list.get(position).getLatitude());
        holder.tou.setImageURI(list.get(position).getUser().getIcon());
        holder.img.setImageURI(list.get(position).getCover());
    }

    @Override
    public int getItemCount() {
        return favoritesBean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView tou;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        SimpleDraweeView img;
        public ViewHolder(View itemView) {
            super(itemView);
            tou = itemView.findViewById(R.id.tou_collect);
            tv1 = itemView.findViewById(R.id.tv1_collect);
            tv2 = itemView.findViewById(R.id.tv2_collect);
            tv3 = itemView.findViewById(R.id.tv3_collect);
            img = itemView.findViewById(R.id.img_collect);
        }
    }
}
