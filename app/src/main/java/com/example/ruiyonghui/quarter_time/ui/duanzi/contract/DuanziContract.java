package com.example.ruiyonghui.quarter_time.ui.duanzi.contract;

import com.example.ruiyonghui.quarter_time.bean.DuanziBean;
import com.example.ruiyonghui.quarter_time.ui.base.BaseContract;

import java.util.List;


/**
 * Created by fxf on 2018.06.05.
 */

public interface DuanziContract {
    interface View extends BaseContract.BaseView {
        void onSuccess(List<DuanziBean.DataBean> list);
        void onSuccessa(String bean);
        void onSuccessb(String bean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getDuanzi(String page);
        void getdianzan(String uid, String jid, String token);

        void getpinglun(String uid, String jid, String token);
    }
}
