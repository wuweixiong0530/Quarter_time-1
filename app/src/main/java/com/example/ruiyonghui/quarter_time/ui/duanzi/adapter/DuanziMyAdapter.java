package com.example.ruiyonghui.quarter_time.ui.duanzi.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.DuanziBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.List;


/**
 * Created by fxf on 2018.06.05.
 */

public class DuanziMyAdapter extends RecyclerView.Adapter<DuanziMyAdapter.ViewHolder> {
    private static final String TAG = "DuanziMyAdapter";
    List<DuanziBean.DataBean> list;
    private Context context;
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(context, "成功了", Toast
                    .LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context, "取消了", Toast
                    .LENGTH_LONG).show();
        }
    };
    OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public DuanziMyAdapter(Context conext, List<DuanziBean.DataBean> list) {
        this.context = conext;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate( R.layout.xrv_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final DuanziBean.DataBean dataBean = list.get(position);

        String imgUrls = (String) dataBean.getUser().getIcon();
        String imgUrl = "";
        if (!TextUtils.isEmpty(imgUrls)) {
            imgUrl = imgUrls.split("\\|")[0];
        }
        holder.iv.setImageURI(imgUrl);
        holder.tvName.setText(dataBean.getUser().getNickname() + "");
        holder.tvTime.setText(dataBean.getCreateTime());
        holder.duanzitext.setText(dataBean.getContent());

        if (mOnItemClickListener != null) {
            //分享

            holder.image_copy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //     Toast.makeText(context, "分享", Toast.LENGTH_SHORT).show();
                    mOnItemClickListener.onClick(dataBean.getJid(), "分享");
//                    Fenxiang fenxiang = new Fenxiang(context);
//                    fenxiang.getonClickShare();
                    //分享
                    UMImage image = new UMImage(context, "http://img.zcool" +
                            ".cn/community/01d881579dc3620000018c1b430c4b.JPG@3000w_1l_2o_100sh.jpg");//网络图片

                    new ShareAction((Activity) context).withMedia(new UMWeb("http://www.baidu.com")).setDisplayList
                            (SHARE_MEDIA.WEIXIN, SHARE_MEDIA
                                            .WEIXIN_CIRCLE,
                                    SHARE_MEDIA.QQ,
                                    SHARE_MEDIA.QZONE)
                            .setCallback(shareListener).open();
                }
            });


            //点赞

            holder.image_report.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //    Toast.makeText(context, "点赞", Toast.LENGTH_SHORT).show();
                    mOnItemClickListener.onClick(dataBean.getJid(), "点赞");
                }
            });


            //评论
            holder.image_pingbi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //   Toast.makeText(context, "评论", Toast.LENGTH_SHORT).show();
                    mOnItemClickListener.onClick(dataBean.getJid(), "评论");
                }
            });
            holder.image_show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.image_jian.setVisibility(View.VISIBLE);
                    holder.image_show.setVisibility(View.GONE);
                    //三个平移动画 平移出来
                    ObjectAnimator firstAnimator = ObjectAnimator.ofFloat(holder.image_pingbi
                            , "translationX", 0, -65 * 3 - 50);
                    ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(holder.image_copy
                            , "translationX", 0, -65 * 2 - 30);
                    ObjectAnimator thirdAnimator = ObjectAnimator.ofFloat(holder.image_report
                            , "translationX", 0, -65 * 1 - 10);

                    //旋转动画
                    ObjectAnimator rotation1 = ObjectAnimator.ofFloat(holder.image_jian, "rotation", 0, 135, 0);
                    ObjectAnimator rotation2 = ObjectAnimator.ofFloat(holder.image_report, "rotation", 0, 180, 0);
                    ObjectAnimator rotation3 = ObjectAnimator.ofFloat(holder.image_copy, "rotation", 0, 180, 0);
                    ObjectAnimator rotation4 = ObjectAnimator.ofFloat(holder.image_pingbi, "rotation", 0, 180, 0);

                    //组合动画
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(800);//动画时长
                    animatorSet.setInterpolator(new OvershootInterpolator());
                    //设置动画一起播放
                    animatorSet.playTogether(rotation1, rotation2, rotation3, rotation4, firstAnimator, secondAnimator, thirdAnimator);

                    animatorSet.start();


                }
            });

            holder.image_jian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.image_jian.setVisibility(View.GONE);
                    holder.image_show.setVisibility(View.VISIBLE);
                    //三个平移回去
                    ObjectAnimator firstAnimator = ObjectAnimator.ofFloat(holder.image_pingbi
                            , "translationX", holder.image_report.getTranslationX(), 0);
                    ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(holder.image_copy
                            , "translationX", holder.image_copy.getTranslationX(), 0);
                    ObjectAnimator thirdAnimator = ObjectAnimator.ofFloat(holder.image_report
                            , "translationX", holder.image_pingbi.getTranslationX(), 0);
                    ObjectAnimator rotation1 = ObjectAnimator.ofFloat(holder.image_show, "rotation", 0, 135, 0);
                    ObjectAnimator rotation2 = ObjectAnimator.ofFloat(holder.image_copy, "rotation", 0, 180, 0);
                    ObjectAnimator rotation3 = ObjectAnimator.ofFloat(holder.image_pingbi, "rotation", 0, 180, 0);
                    ObjectAnimator rotation4 = ObjectAnimator.ofFloat(holder.image_report, "rotation", 0, 180, 0);

                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(800);
                    animatorSet.setInterpolator(new OvershootInterpolator());
                    animatorSet.playTogether(rotation1, rotation2, rotation3, rotation4, firstAnimator, secondAnimator, thirdAnimator);

                    animatorSet.start();

                }
            });


        }

    }

    @Override
    public int getItemCount() {
        return list.size();//显示的条目数
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView iv;
        private final TextView tvName;
        private final TextView tvTime;
        private final TextView duanzitext;

        private ImageView image_show;
        private ImageView image_jian;
        private ImageView image_report;
        private ImageView image_copy;
        private ImageView image_pingbi;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.img);
            tvName = itemView.findViewById(R.id.tv_name);
            tvTime = itemView.findViewById(R.id.tv_time);
            duanzitext = itemView.findViewById(R.id.item_text);
            image_show = itemView.findViewById(R.id.image_show);
            image_jian = itemView.findViewById(R.id.image_jian);
            image_report = itemView.findViewById(R.id.image_report);
            image_copy = itemView.findViewById(R.id.image_copy);
            image_pingbi = itemView.findViewById(R.id.image_pingbi);

        }
    }



}