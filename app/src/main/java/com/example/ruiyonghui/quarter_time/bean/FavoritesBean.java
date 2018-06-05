package com.example.ruiyonghui.quarter_time.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/5,0005.
 * 收藏列表
 */

public class FavoritesBean {

    /**
     * msg : 获取收藏列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151246390747520171205165122.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":1,"latitude":"40.040475","localUri":null,"longitude":"116.300124","playNum":0,"praiseNum":0,"uid":2997,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512108751006e.png","nickname":"李薇","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512463907475wx_camera_1509596718115.mp4","wid":45,"workDesc":"ll"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1512461482662oppo2.3gp","createTime":"2017-12-17T19:20:44","favoriteNum":2,"latitude":"40.046568","localUri":null,"longitude":"116.306215","playNum":1,"praiseNum":0,"uid":169,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522049337137cropped_1522049339259.jpg","nickname":"不熟","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512461482662oppo2.3gp","wid":37,"workDesc":"杀一次"},{"commentNum":3,"comments":[{"cid":74,"content":"111","createTime":"2017-12-18T09:07:18","jid":null,"mvp":null,"nickname":"14","praiseNum":0,"uid":3028,"wid":77},{"cid":75,"content":"111","createTime":"2017-12-18T09:07:29","jid":null,"mvp":null,"nickname":"14","praiseNum":0,"uid":3028,"wid":77},{"cid":138,"content":"222","createTime":"2017-12-18T21:22:29","jid":null,"mvp":null,"nickname":"小五","praiseNum":0,"uid":313,"wid":77}],"cover":"https://www.zhaoapi.cn/images/quarter/1512542333693PictureSelector_20171206_143743.mp4","createTime":"2017-12-17T19:20:44","favoriteNum":2,"latitude":"40","localUri":null,"longitude":"116","playNum":6,"praiseNum":0,"uid":92,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/151425855261420171226112227.jpg","nickname":"jinlin","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512542333693PictureSelector_20171206_143743.mp4","wid":77,"workDesc":""}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/151246390747520171205165122.jpg
         * createTime : 2017-12-17T19:20:44
         * favoriteNum : 1
         * latitude : 40.040475
         * localUri : null
         * longitude : 116.300124
         * playNum : 0
         * praiseNum : 0
         * uid : 2997
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512108751006e.png","nickname":"李薇","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1512463907475wx_camera_1509596718115.mp4
         * wid : 45
         * workDesc : ll
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<?> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1512108751006e.png
             * nickname : 李薇
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
