package io.jopen.core.common.io;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Http请求组件
 *
 * @author maxuefeng
 */
public class HttpRequester {


    private OkHttpClient httpClient;

    public HttpRequester(String url) {
        this(url, 1000, 1000, 1000);
    }

    public HttpRequester(String url, long connectTimeOut, long readTimeOut, long writeTimeout) {
        this(url, connectTimeOut, readTimeOut, writeTimeout, null);
    }


    public HttpRequester(String url, long connectTimeOut, long readTimeOut, long writeTimeout, Proxy proxy) {
        this(url, connectTimeOut, readTimeOut, writeTimeout, proxy, null);
    }

    public HttpRequester(String url, long connectTimeOut, long readTimeOut, long writeTimeout, Proxy proxy, List<Interceptor> interceptors) {

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.readTimeout(readTimeOut, TimeUnit.SECONDS)
                .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .proxy(proxy);

        if (interceptors != null && interceptors.size() > 0) {
            interceptors.forEach(clientBuilder::addInterceptor);
        }
        this.httpClient = clientBuilder.build();
    }
}
