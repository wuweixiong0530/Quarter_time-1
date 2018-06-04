package com.example.ruiyonghui.quarter_time.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4,0004.
 * 获取作品个人中心
 */

public class GetWorkInfoBean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : {"user":{"age":"18","fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"worksEntities":[]}
     */


    private String msg;
    private String code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user : {"age":"18","fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}
         * worksEntities : []
         */

        private UserBean user;
        private List<?> worksEntities;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<?> getWorksEntities() {
            return worksEntities;
        }

        public void setWorksEntities(List<?> worksEntities) {
            this.worksEntities = worksEntities;
        }

        public static class UserBean {
            /**
             * age : 18
             * fans : null
             * follow : false
             * icon : null
             * nickname : null
             * praiseNum : null
             */

            private String age;
            private String fans;
            private boolean follow;
            private Object icon;
            private Object nickname;
            private String praiseNum;

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
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

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
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
