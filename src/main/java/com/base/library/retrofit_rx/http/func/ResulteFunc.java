package com.base.library.retrofit_rx.http.func;


import android.content.Intent;

import com.alibaba.fastjson.JSONObject;
import com.base.library.retrofit_rx.Api.resulte.BaseResulte;
import com.base.library.retrofit_rx.RxRetrofitApp;
import com.base.library.retrofit_rx.exception.HttpTimeException;
import com.base.library.utils.AbStrUtil;

import rx.functions.Func1;

/**
 * 服务器返回数据判断
 * Created by WZG on 2017/3/23.
 */

public class ResulteFunc implements Func1<Object, Object> {
    @Override
    public Object call(Object o) {
        if (o == null || "".equals(o.toString())) {
            throw new HttpTimeException(HttpTimeException.CHACHE_HTTP_ERROR, "服务器问题，请联系管理员");
        }
        /*数据回调格式统一判断*/
        BaseResulte resulte = JSONObject.parseObject(o.toString(), BaseResulte.class);

        if (resulte.getCode() == -1) {
            throw new HttpTimeException(HttpTimeException.CHACHE_HTTP_POST_ERROR,
                    AbStrUtil.isEmpty(resulte.getMsg()) ? "信息错误" : resulte.getMsg());
        } else if (resulte.getCode() == 2) {
            /*用户在其他设备登录*/
            Intent it = new Intent();
            it.putExtra("error_msg", "登录异常,该账号已在别的设备上登录");
            it.putExtra("login", true);
            it.setClassName("com.project.yfpatient", "com.project.yfpatient.ui.MainActivity");
            RxRetrofitApp.getApplication().startActivity(it);
            throw new HttpTimeException(HttpTimeException.CHACHE_MORE_LOGIN_ERROR, "该账号已在别的设备上登录");
        }

        return AbStrUtil.isEmpty(resulte.getData()) ? "" : resulte.getData();
    }
}
