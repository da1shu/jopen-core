package io.jopen.core.common;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;


/**
 * Google Files Cannot extends;
 *
 * @author maxuefeng [m17793873123@163.com]
 */
public class Files implements Serializable {


    /**
     * 将某个文件的所有内容读出来拼接成一个字符串
     *
     * @return all line but It is a string
     * @see com.google.common.io.Files#readLines(java.io.File, java.nio.charset.Charset)
     * @see java.nio.file.Files#readAllLines(Path)
     * @see java.nio.file.Files#readAllBytes(Path)
     */
    public static String readAllLines(String path) throws IOException {

        File file = new File(path);

        List<String> lines = com.google.common.io.Files.readLines(file, Charset.forName("UTF-8"));

        StringBuilder rs = new StringBuilder();

        lines.forEach(t -> rs.append(t.trim()));

        return rs.toString();
    }

    public static double getFileSizeKiloBytes(byte[] src) throws IOException {

        return (double) src.length / 1024;
    }

    /**
     * @param file
     * @return
     */
    public static double getFileSizeMegaBytes(File file) {
        return (double) file.length() / (1024 * 1024);
    }

    /**
     * @param file
     * @return
     */
    public static double getFileSizeKiloBytes(File file) {
        return (double) file.length() / 1024;
    }

    /**
     * @param file
     * @return
     */
    public static double getFileSizeBytes(File file) {
        return file.length();
    }


    /**
     * @param originName
     * @return
     */
    public static String getFileSuffix(String originName) {

        String[] result = originName.split("\\.");

        return result[result.length - 1];
    }

}
