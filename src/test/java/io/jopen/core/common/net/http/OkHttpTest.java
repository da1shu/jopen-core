package io.jopen.core.common.net.http;

import com.google.common.collect.Maps;
import io.jopen.core.common.json.Json;
import okhttp3.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * OkHttp 代理服务   reid.red是新加坡远程代理服务器
 *
 * @author maxuefeng
 */
public class OkHttpTest {

    @Test
    public void testProxy2GoogleChrome() throws IOException {

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("reid.red", 60103));

        OkHttpClient client = clientBuilder.proxy(proxy).build();

        String url = "https://www.google.com/search?source=hp&ei=5j88XJeWB8Lz9QOQrYDIAg&q=jdk+dynamic+proxy&oq=&gs_l=psy-ab.1.1.35i39l6.0.0..2824...2.0..0.185.185.0j1......0......gws-wiz.....6.5E4AQKCWI60";

        Request request = new Request.Builder().get().url(url).build();
        Response response = client.newCall(request).execute();

        assert response.body() != null;
        System.out.println(response.body().string());
    }

    @Test
    public void serviceTest() throws IOException {

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        OkHttpClient client = clientBuilder.build();
        String url = "http://www.qnbaoxiu.com/guns/charge/area";

        Map<String, String> param = Maps.newHashMap();
        param.put("level", "province");

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), Json.of(param).toString());
        Request request = new Request.Builder().post(body).url(url).build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }

    @Test
    public void testWxLink() throws IOException {
        String url = "https://mp.weixin.qq.com/s/11Ta97w9RrchGw97Iwb_AA";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().get().url(url).get().build();

        Response response = client.newCall(request).execute();

        assert response.body() != null;
        System.out.println(response.body().string());
    }


    @Test
    public void loadCookieLoginWebTest() {

        CookieJar cookieJar = new CookieJar() {

            //Cookie缓存区
            private final Map<String, List<Cookie>> cookiesMap = new HashMap<String, List<Cookie>>();

            @Override
            public void saveFromResponse(HttpUrl arg0, List<Cookie> arg1) {

                //移除相同的url的Cookie
                String host = arg0.host();
                List<Cookie> cookiesList = cookiesMap.get(host);

                if (cookiesList != null) {
                    cookiesMap.remove(host);
                }

                cookiesMap.put(host, arg1);
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl arg0) {

                List<Cookie> cookiesList = cookiesMap.get(arg0.host());

                return cookiesList != null ? cookiesList : new ArrayList<>();
            }
        };

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)
                .build();

        //创建登陆的表单
        FormBody loginBody = new FormBody.Builder()
                .add("_xsrf", "bf284aba4cc706ebfc5ebcba1c4f97fc")
                .add("password", "cay1314159")
                .add("captcha_type", "cn")
                .add("remember_me", "true")
                .add("phone_num", "15520762775")
                .build();

        //创建Request请求
        Request loginRequest = new Request.Builder()
                .url("https://www.zhihu.com/login/phone_num")
                .post(loginBody)
                .build();

        Call loginCall = client.newCall(loginRequest);

        try {
            //非异步执行
            Response loginResponse = loginCall.execute();

            //测试是否登陆成功
            System.out.println(loginResponse.body().string());

            //获取返回数据的头部
            Headers headers = loginResponse.headers();

            HttpUrl loginUrl = loginRequest.url();

            //获取头部的Cookie,注意：可以通过Cooke.parseAll()来获取
            List<Cookie> cookies = Cookie.parseAll(loginUrl, headers);

            //防止header没有Cookie的情况
            if (cookies != null) {
                //存储到Cookie管理器中
                client.cookieJar().saveFromResponse(loginUrl, cookies);//这样就将Cookie存储到缓存中了
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //获取需要提交的CookieStr
        StringBuilder cookieStr = new StringBuilder();
        //从缓存中获取Cookie
        List<Cookie> cookies = client.cookieJar().loadForRequest(loginRequest.url());
        //将Cookie数据弄成一行
        for (Cookie cookie : cookies) {
            cookieStr.append(cookie.name()).append("=").append(cookie.value()).append(";");
        }
        System.out.println(cookieStr.toString());

        //设置提交的请求
        Request attentionRequest = new Request
                .Builder()
                .url("https://www.zhihu.com/people/chen-yan-xiang-83/followees")
                .header("Cookie", cookieStr.toString())
                .build();
        Call attentionCall = client.newCall(attentionRequest);
        try {

            //连接网络
            Response attentionResponse = attentionCall.execute();

            if (attentionResponse.isSuccessful()) {

                //获取返回的数据
                String data = attentionResponse.body().string();

                //测试
                System.out.println(data);

                //解析数据
              /*  Document document = Jsoup.parse(data);
                Elements attentions = document.select("div.zm-profile-card");

                for (Element attention : attentions) {
                    System.out.println("name：" + attention.select("h2").text() + "  简介：" + attention.select("span").text());
                }*/
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * headers.add("Planet-Access-Token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1SWQiOiJhZjg0MzYzMDNkMTc0NDJiOTEzNjQxMmU5OTNkZWJmZSIsImV4cCI6MTU1NTY3NDkyOH0.R2pXURBWeKR6hFILb8vx7vPRHXqa14bN-Tylh6Yz0IY");
     */
    @Test
    public void testFileUpload() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10000000, TimeUnit.MILLISECONDS)
                .build();

        File file = new File("14d7fda775734b83a7229cf6ff17b73a.jpg");

        RequestBody fileBody = RequestBody.create(MediaType.parse("Multipart/form-data"), file);

        // form 表单形式上传
        MultipartBody.Builder requestBody = new MultipartBody
                .Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("Multipart/form-data", "file", fileBody);

        requestBody.setType(MultipartBody.FORM);

        Request request = new Request.Builder()
                .url("http://localhost:8080/planet/api/consumption/credential/upload")
                .post(requestBody.build())
                .header("Planet-Access-Token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1SWQiOiJhZjg0MzYzMDNkMTc0NDJiOTEzNjQxMmU5OTNkZWJmZSIsImV4cCI6MTU1NTY3NDkyOH0.R2pXURBWeKR6hFILb8vx7vPRHXqa14bN-Tylh6Yz0IY")
                .build();


        Response rs = client.newCall(request).execute();

        System.err.println(rs.body().string());
    }
}











