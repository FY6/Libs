package com.base.library.retrofit_rx.Api;

import com.alibaba.fastjson.JSONObject;
import com.base.library.retrofit_rx.RxRetrofitApp;
import com.base.library.utils.AbSharedUtil;
import com.base.library.utils.AbStrUtil;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Describe:请求数据统一封装类
 * <p>
 * Created by zhigang wei
 * on 2017/8/29.
 * <p>
 * Company :Sichuan Ziyan
 */
public abstract class BaseApi {
    /*是否能取消加载框*/
    private transient boolean cancel = false;
    /*是否显示加载框*/
    private transient boolean showProgress = true;
    /*是否需要缓存处理*/
    private transient boolean cache = false;
    /*基础url*/
//    public transient static String baseUrl = "http://yfmedical.ngrok.xiaomiqiu.cn/";
//    public transient static String baseUrl = "http://yfubtest.ngrok.xiaomiqiu.cn/";
//    public transient static String baseUrl = "http://192.168.1.119:8086/";
    public transient static String baseUrl = "http://www.shangem8.net/";
    /*方法-如果需要缓存必须设置这个参数；不需要不用設置*/
    private transient String method = "";
    /*超时时间-默认10秒*/
    private transient int connectionTime = 15;
    /*有网情况下的本地缓存时间默xxx秒*/
    private transient int cookieNetWorkTime = 60;
    /*无网络的情况下本地缓存时间默认30天*/
    private transient int cookieNoNetWorkTime = 24 * 60 * 60 * 30;
    /* retry次数*/
    private transient int retryCount = 0;
    /*retry延迟*/
    private transient long retryDelay = 100;
    /*retry叠加延迟*/
    private transient long retryIncreaseDelay = 100;
    /*缓存url*/
    private transient String cacheUrl;
    /*常用服务器校验字段*/
    private transient static String config;

    /**
     * 设置参数
     *
     * @param retrofit
     * @return
     */
    public abstract Observable getObservable(Retrofit retrofit);

    public int getCookieNoNetWorkTime() {
        return cookieNoNetWorkTime;
    }

    public void setCookieNoNetWorkTime(int cookieNoNetWorkTime) {
        this.cookieNoNetWorkTime = cookieNoNetWorkTime;
    }

    public int getCookieNetWorkTime() {
        return cookieNetWorkTime;
    }

    public void setCookieNetWorkTime(int cookieNetWorkTime) {
        this.cookieNetWorkTime = cookieNetWorkTime;
    }

    public int getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(int connectionTime) {
        this.connectionTime = connectionTime;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUrl() {
        return baseUrl + getMethod();
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public boolean isShowProgress() {
        return showProgress;
    }

    public void setShowProgress(boolean showProgress) {
        this.showProgress = showProgress;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public long getRetryDelay() {
        return retryDelay;
    }

    public void setRetryDelay(long retryDelay) {
        this.retryDelay = retryDelay;
    }

    public long getRetryIncreaseDelay() {
        return retryIncreaseDelay;
    }

    public void setRetryIncreaseDelay(long retryIncreaseDelay) {
        this.retryIncreaseDelay = retryIncreaseDelay;
    }

    public String getCacheUrl() {
        if (AbStrUtil.isEmpty(cacheUrl)) {
            return getUrl();
        }
        return cacheUrl;
    }

    public void setCacheUrl(String cacheUrl) {
        this.cacheUrl = cacheUrl;
    }


    public static String getConfig() {
        if (AbStrUtil.isEmpty(config)) {
            config = AbSharedUtil.getString(RxRetrofitApp.getApplication(), "config");
        }
        return config;
    }

    public static void setConfig(Config config) {
        BaseApi.config = JSONObject.toJSONString(config);
        AbSharedUtil.putString(RxRetrofitApp.getApplication(), "config", BaseApi.config);
    }

}
