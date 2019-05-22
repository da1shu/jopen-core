package io.jopen.core.common.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    @Test
    public void extractInfo(){

        String source  = "创 建 时 间 2019-03-18 19:14";

        System.err.println(source);

        int year = LocalDate.now().getYear();

        String[] afterSplit = source.split(year + "");

        String lastString = afterSplit[afterSplit.length - 1];

        // 从此处开始提取时间信息
        String newDateString = year + lastString;


    }


}
