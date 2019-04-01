package io.jopen.core.common.io;

import io.jopen.core.common.json.MutableJson;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

/**
 * @author maxuefeng
 */
public class ResponseDecorator {

    public Response response;

    public JSONObject result;

    public ResponseDecorator(Response response) {
        this.response = response;
    }

    public JSONObject wrap() throws IOException {

        Objects.requireNonNull(response);

        ResponseBody body = response.body();

        // 响应结果为Json
        if (body != null && this.response.isSuccessful() && "application/json".equals(response.header("content-type"))) {
            this.result = MutableJson.of(body.string());
        } else {
            this.result = MutableJson.of("code", response.code(), "message", response.message());
        }

        return this.result;
    }
}
