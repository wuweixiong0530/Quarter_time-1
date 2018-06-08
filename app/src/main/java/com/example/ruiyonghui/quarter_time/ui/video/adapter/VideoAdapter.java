package com.example.ruiyonghui.quarter_time.ui.video.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by wwx on 2018/6/7,0007.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder>{
    private Context context;
    private HotVideoBean bean;
    private static final String TAG = "VideoAdapter";

    public VideoAdapter(Context context, HotVideoBean hotVideoBean) {
        this.context = context;
        this.bean = hotVideoBean;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        View view = View.inflate(context,R.layout.video_item,null);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
        List<HotVideoBean.DataBean> list = bean.getData();
        holder.player.setUp(list.get(position).getVideoUrl(),JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,list.get(position).getWid());
    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        JZVideoPlayerStandard player;

        public ViewHolder(View itemView) {
            super(itemView);
            player = itemView.findViewById(R.id.player_video);
            Log.i(TAG, "ViewHolder: sssssss");
            int width = ((Activity) player.getContext()).getWindowManager().getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams params = player.getLayoutParams();
            //设置图片的相对于屏幕的宽高比
            params.width = width/2;
            params.height =  (int) (200 + Math.random() * 400) ;
            player.setLayoutParams(params);

        }
    }
}
