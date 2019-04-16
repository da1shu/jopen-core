package io.jopen.core.common;

import com.sun.javafx.binding.StringFormatter;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

/**
 * @author maxuefeng
 */
public class Util {

    /**
     * @param object
     * @param strictly 是否严格校验
     * @return
     */
    public static boolean isEmpty(Object object, boolean strictly) {

        if (object == null) {
            return true;
        }

        if (object instanceof String) {
            return StringUtils.isBlank(object.toString());
        }

        if (strictly) {

            // 集合类型
            if (object instanceof Collection) {
                Collection c = (Collection) object;
                return c.size() != 0;
            }

            // 数组对象
            if (object instanceof Object[]) {
                Object[] o = (Object[]) object;
                return o.length != 0;
            }

            // 自定义对象[自定义对象需要判断指定的字段不可为空]

        }
        return true;
    }

    /**
     * 存在重复数据的BUG
     */
    @Deprecated
    public static class PrimaryGenerator {


        private static PrimaryGenerator primaryGenerator = null;

        private PrimaryGenerator() {
        }

        /**
         * 取得PrimaryGenerator的单例实现
         *
         * @return
         */
        public static PrimaryGenerator getInstance() {
            if (primaryGenerator == null) {
                synchronized (PrimaryGenerator.class) {
                    if (primaryGenerator == null) {
                        primaryGenerator = new PrimaryGenerator();
                    }
                }
            }
            return primaryGenerator;
        }

        /**
         * 产生随机的2位数
         *
         * @return
         */
        private String getTwo() {
            Random rad = new Random();

            String result = rad.nextInt(100) + "";

            if (result.length() == 1) {
                result = "0" + result;
            }
            return result;
        }

        /**
         * 生成交易流水号
         *
         * @return
         */
        public synchronized String sn() {

            String date = Formatter.now(Formatter.P.P8);

            String seconds = Formatter.now(Formatter.P.P9);

            return date + "00001000" + getTwo() + "00" + seconds + getTwo();
        }

    }
}
