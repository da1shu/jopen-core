package io.jopen.core.common.util;

import com.google.common.collect.ImmutableMap;
import io.jopen.core.common.io.UploadHelper;
import org.json.JSONObject;
import org.junit.Test;

import java.io.File;

/**
 * @author maxuefeng
 */
public class UploadHelperTest {

    @Test
    public void testSimpleUploadFile() {
        UploadHelper helper = new UploadHelper();

        JSONObject result = helper.upload("http://localhost:8080/planet/api/consumption/credential/upload",
                new File("14d7fda775734b83a7229cf6ff17b73a.jpg"),
                ImmutableMap.of("Planet-Access-Token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1SWQiOiJhZjg0MzYzMDNkMTc0NDJiOTEzNjQxMmU5OTNkZWJmZSIsImV4cCI6MTU1NTY3NDkyOH0.R2pXURBWeKR6hFILb8vx7vPRHXqa14bN-Tylh6Yz0IY"));

        System.err.println(result);
    }

}
