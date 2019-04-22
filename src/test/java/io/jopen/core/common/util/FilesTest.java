package io.jopen.core.common.util;

import io.jopen.core.common.Files;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author maxuefeng
 */
public class FilesTest {

    @Test
    public void testGetFileSize() {
        File file = new File("E:\\workplace\\biz-api\\tmp\\1.jpg");

        // System.err.println(Files.getFileSizeBytes(file));

        System.err.println(Files.getFileSizeKiloBytes(file));

       // System.err.println(Files.getFileSizeMegaBytes(file));
    }

    /**
     * 80634765625KB
     *
     * @throws IOException
     */
    @Test
    public void testGetFileSizeByteArray() throws IOException {
        File file = new File("E:\\workplace\\biz-api\\tmp\\1.jpg");

        byte[] src = com.google.common.io.Files.toByteArray(file);

        double size = Files.getFileSizeKiloBytes(src);

        System.err.println(size);
    }
}
