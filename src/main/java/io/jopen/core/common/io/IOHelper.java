package io.jopen.core.common.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author maxuefeng
 */
public class IOHelper {

    /**
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static byte[] isToBytes(InputStream in) throws IOException {
        if (in == null) {
            return new byte[0];
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = in.read(buffer)) != -1) {
            output.write(buffer, 0, len);
        }
        output.flush();
        return output.toByteArray();
    }

    public static BufferedImage bytesToBufferImage(byte[] img_src) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(img_src);
        return ImageIO.read(bais);
    }
}
