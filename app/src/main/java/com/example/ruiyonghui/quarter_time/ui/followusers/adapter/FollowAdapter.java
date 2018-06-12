package com.example.ruiyonghui.quarter_time.ui.followusers.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.FavoritesBean;
import com.example.ruiyonghui.quarter_time.bean.FollowUsersBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class FollowAdapter extends RecyclerView.Adapter<FollowAdapter.ViewHolder>{

    private Context context;
    private FollowUsersBean followUsersBean;

    public FollowAdapter(Context context, FollowUsersBean followUsersBean) {
        this.context = context;
        this.followUsersBean = followUsersBean;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        View view = View.inflate(context,R.layout.followusers_item,null);
       // ((RecyclerView) view).getAdapter().notifyItemRangeChanged(0,followUsersBean.getData().size());
        holder = new FollowAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<FollowUsersBean.DataBean> list = followUsersBean.getData();
        holder.tou_followusers.setImageURI( list.get(position).getIcon() );
        holder.followusers_name.setText( list.get( position ).getUsername() );
        holder.followusers_time.setText( list.get( position ).getCreatetime() );

    }

    @Override
    public int getItemCount() {
        return followUsersBean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView tou_followusers;
        TextView followusers_name;
        TextView followusers_time;

        public ViewHolder(View itemView) {
            super(itemView);
            tou_followusers = itemView.findViewById( R.id.tou_followusers);
            followusers_name = itemView.findViewById(R.id.followusers_name);
            followusers_time = itemView.findViewById(R.id.followusers_time);
        }
    }
}
