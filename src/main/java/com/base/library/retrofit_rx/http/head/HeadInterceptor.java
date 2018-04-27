package com.base.library.retrofit_rx.http.head;

import android.content.Intent;

import com.base.library.retrofit_rx.Api.BaseApi;
import com.base.library.retrofit_rx.RxRetrofitApp;
import com.base.library.retrofit_rx.exception.HttpTimeException;
import com.base.library.utils.AbStrUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Describe:统一的head拦截器处理
 * <p>
 * Created by zhigang wei
 * on 2018/1/10
 * <p>
 * Company :Sichuan Ziyan
 */
public class HeadInterceptor implements Interceptor {
    private BaseApi baseApi;

    public HeadInterceptor(BaseApi baseApi) {
        this.baseApi = baseApi;
        if (AbStrUtil.isEmpty(baseApi.getConfig())) {
            Intent msgIntent = new Intent(Intent.ACTION_MAIN);
            msgIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            msgIntent.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED | Intent.FLAG_ACTIVITY_NEW_TASK);
            msgIntent.putExtra("showType", 2);
            msgIntent.setClassName("com.project.yfpatient", "com.project.yfpatient.ui.MainActivity");
            RxRetrofitApp.getApplication().startActivity(msgIntent);
            throw new HttpTimeException(HttpTimeException.HTTP_CONFIG_ERROR, "config信息异常");
        }
    }

    @Override
    public Response intercept(Chain chain) throws IOException {


        Request original = chain.request();
        /*设置方法*/
        String method = original.url().url().toString().replace(baseApi.getBaseUrl(), "");
        baseApi.setMethod(method);

        /*设置head信息*/
        Request request = original.newBuilder()
                .header("config", baseApi.getConfig())
                .method(original.method(), original.body())
                .build();


        return chain.proceed(request);
    }
}
