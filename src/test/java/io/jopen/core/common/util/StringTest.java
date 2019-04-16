package io.jopen.core.common.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author maxuefeng
 */
public class StringTest {


    @Test
    public void testSubstringExclude() {

        String tmp = "abcacbannnh";

        String substring = tmp.substring(0, tmp.length());

        System.out.println(substring);
    }

    /**
     * @throws NullPointerException 空指针 String.valueOf(null)默认调用的是String.valueOf(byte[] a)
     */
    @Test
    public void getCharIndex() {

        String tmp = "HelloWorldW";

        System.err.println(tmp.indexOf("Z"));

        System.err.println(String.valueOf(null));

    }


}
