package com.example.ruiyonghui.quarter_time.bean;

/**
 * Created by Administrator on 2018/6/4,0004.
 * 版本更新bean类
 */

public class VersionBean {

    /**
     * msg : 获取版本信息成功
     * code : 0
     * data : {"apkUrl":"https://www.zhaoapi.cn/version/app.apk","desc":"V2.0升级，修复部分bug，优化程序性能！","type":2,"vId":3,"versionCode":"200","versionName":"2.0"}
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
         * apkUrl : https://www.zhaoapi.cn/version/app.apk
         * desc : V2.0升级，修复部分bug，优化程序性能！
         * type : 2
         * vId : 3
         * versionCode : 200
         * versionName : 2.0
         */

        private String apkUrl;
        private String desc;
        private int type;
        private int vId;
        private String versionCode;
        private String versionName;

        public String getApkUrl() {
            return apkUrl;
        }

        public void setApkUrl(String apkUrl) {
            this.apkUrl = apkUrl;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getVId() {
            return vId;
        }

        public void setVId(int vId) {
            this.vId = vId;
        }

        public String getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(String versionCode) {
            this.versionCode = versionCode;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }
    }
}
