package com.example.ruiyonghui.quarter_time.ui.recommend.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.GuanZhuBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/6,0006.
 */

public class GuanZhuAdapter extends RecyclerView.Adapter<GuanZhuAdapter.ViewHolder>{
    private Context context;
    private GuanZhuBean bean;

    public GuanZhuAdapter(Context context, GuanZhuBean guanZhuBean) {
        this.context = context;
        this.bean = guanZhuBean;
    }

    @NonNull
    @Override
    public GuanZhuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        View view = View.inflate(context, R.layout.guanzhu_item, null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GuanZhuAdapter.ViewHolder holder, int position) {
        List<GuanZhuBean.DataBean> list = bean.getData();
        holder.tv1.setText(list.get(position).getUsername());
        holder.tv2.setText(list.get(position).getCreatetime());
        holder.tv3.setText(list.get(position).getAppsecret());
        holder.tou.setImageURI(list.get(position).getIcon());
//        holder.img_guanzhu.setImageURI(Uri.parse(list.get(position).getIcon()));
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
        ImageView img_guanzhu;
        public ViewHolder(View itemView) {
            super(itemView);
            tou = itemView.findViewById(R.id.tou_collect);
            tv1 = itemView.findViewById(R.id.tv1_collect);
            tv2 = itemView.findViewById(R.id.tv2_collect);
            tv3 = itemView.findViewById(R.id.tv3_collect);
            img_guanzhu = itemView.findViewById(R.id.img1_guanzhu);

        }
    }
}
