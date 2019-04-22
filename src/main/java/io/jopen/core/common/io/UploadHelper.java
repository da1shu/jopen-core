package io.jopen.core.common.io;

import io.jopen.core.common.json.Json;
import okhttp3.*;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author maxuefeng
 */
public class UploadHelper {

    /**
     * TODO 注意设置超时时间
     */
    private static final OkHttpClient client = new OkHttpClient();

    /**
     * @param url
     * @param file
     * @param token
     * @return
     */
    public static JSONObject upload(String url, File file,  Map<String, String> token) {

        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), fileBody)
                .build();

        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);

        token.forEach(builder::header);

        Request request = builder.build();

        Response response;
        try {
            response = client.newCall(request).execute();
            String jsonString = response.body().string();
            if (!response.isSuccessful()) {

                return Json.of("code", "0", "msg", "request Error");

            } else {

                return new JSONObject(jsonString);
            }
        } catch (IOException ex) {
            return Json.of("code", "0", "msg", ex.getMessage());
        }
    }
}
