package io.jopen.core.common.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import io.jopen.core.common.io.ImageHelper;
import org.junit.Test;

/**
 * @author maxuefeng [github id:ubuntu-maxfeng 163email:m17793873123@163.com]
 */
public class ImageUtilTest {

    @Test
    public void testImageConvert() {

        byte[] bytes = ImageHelper.image2Byte("/usr/local/java-workplace/jopen-common/src/main/resources/tmp.jpeg");

        ImageHelper.byte2Image(bytes, "/usr/local/java-workplace/jopen-common/src/main/resources/tmp22.jpeg");

        BiMap<String, Integer> userId = HashBiMap.create();

        String userForId = userId.inverse().get(1);

    }
}
