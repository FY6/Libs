package com.base.library.retrofit_rx.http.func;

import com.alibaba.fastjson.JSONObject;
import com.base.library.retrofit_rx.Api.BaseApi;
import com.base.library.retrofit_rx.Api.Config;
import com.base.library.retrofit_rx.Api.resulte.BaseResulte;
import com.base.library.retrofit_rx.exception.HttpTimeException;
import com.base.library.utils.AbStrUtil;

import retrofit2.Retrofit;
import retrofit2.http.POST;
import rx.Observable;
import rx.functions.Func1;

/**
 * Describe:toekan失效统一处理
 * <p>
 * Created by zhigang wei
 * on 2018/1/12.
 * <p>
 */
public class TokeanFunc implements Func1<Object, Observable> {
    private BaseApi basePar;
    private Retrofit retrofit;

    public TokeanFunc(BaseApi basePar, Retrofit retrofit) {
        this.basePar = basePar;
        this.retrofit = retrofit;
    }

    @Override
    public Observable call(Object o) {
        /*这里简单的以tokean为空来判断，实际运用中需要通过服务器错误标示来判断启用tokean机制*/
        if (o == null || "".equals(o.toString())) {
            throw new HttpTimeException(HttpTimeException.CHACHE_HTTP_ERROR, "服务器问题，请联系管理员");
        }
         /*数据回调格式统一判断*/
        BaseResulte resulte = JSONObject.parseObject(o.toString(), BaseResulte.class);

        if (resulte.getCode() == 1) {
            return retrofit.create(TokeanServiceApi.class).tokean()
                    .flatMap(new Func1() {
                        @Override
                        public Observable call(Object o) {
                            if (!AbStrUtil.isEmpty(o.toString())) {
                                BaseResulte resulte = JSONObject.parseObject(o.toString(), BaseResulte.class);
                                if (0 == resulte.getCode()) {
                                    /*解析出tokean传入到当前请求的api接口类中*/
                                    Config config = JSONObject.parseObject(BaseApi.getConfig(), Config.class);
                                    config.setToken(resulte.getData());
                                    basePar.setConfig(config);
                                } else {
                                    throw new HttpTimeException(HttpTimeException.HTTP_TOKEAN_ERROR, "请求失败");
                                }
                                /*继续当前接口请求*/
                                return basePar.getObservable(retrofit);
                            }
                            throw new HttpTimeException(HttpTimeException.HTTP_TOKEAN_ERROR, "请求失败");
                        }
                    });
        } else {
            return Observable.just(o);
        }
    }


    public interface TokeanServiceApi {
        /**
         * 获取最新tokean
         *
         * @return
         */
        @POST("yf/medical/app/user/getRePatientToken")
        Observable<String> tokean();
    }
}
