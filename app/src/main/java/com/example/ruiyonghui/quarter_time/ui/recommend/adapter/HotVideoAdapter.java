package com.example.ruiyonghui.quarter_time.ui.recommend.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


/**
 * Created by wwx on 2018/6/6,0006.
 */

public class HotVideoAdapter extends RecyclerView.Adapter<HotVideoAdapter.ViewHolder> {
    private Context context;
    private HotVideoBean bean;

    public HotVideoAdapter(Context context, HotVideoBean hotVideoBean) {
        this.context = context;
        this.bean = hotVideoBean;
    }

    @NonNull
    @Override
    public HotVideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        View view = View.inflate(context, R.layout.collect_item, null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotVideoAdapter.ViewHolder holder, int position) {
        List<HotVideoBean.DataBean> list = bean.getData();
        holder.tv1.setText(list.get(position).getUser().getNickname());
        holder.tv2.setText(list.get(position).getCreateTime());
        holder.tv3.setText(list.get(position).getLatitude());
        holder.tou.setImageURI(list.get(position).getUser().getIcon());
        holder.img.setImageURI(list.get(position).getCover());
    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
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
