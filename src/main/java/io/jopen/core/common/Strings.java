package io.jopen.core.common;

import com.google.errorprone.annotations.Var;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.UUID;

/**
 * @author maxuefeng
 */
public class Strings {

    /**
     * @return
     */
    public static String id() {


        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void convert(int num) {
        //12345
        String[] mark = new String[]{"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千", "万"};
        String[] numCn = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

        char[] numArrRev = String.valueOf(num).toCharArray();

        StringBuilder container = new StringBuilder();

        for (int i = 0; i < numArrRev.length; i++) {
            Integer val = Integer.valueOf(String.valueOf(numArrRev[i]));
            String number = numCn[val];
            int x = numArrRev.length - i - 1;
            String sign = mark[x];

            if (val == 0) {
                if (x % 4 != 0) {// 删除单位
                    sign = "";
                }
                if (i < numArrRev.length - 1) {
                    Integer val1 = Integer.parseInt(String.valueOf(numArrRev[i + 1]));
                    if (val.equals(val1)) {
                        number = "";
                    } else if ("万".equals(sign) || "亿".equals(sign)) {
                        number = "";
                    }
                } else if (i == numArrRev.length - 1) {
                    number = "";
                }
            }

            container.append(number).append(sign);
        }

        System.out.println(num + "-->" + container.toString());
    }


    /**
     * 大写数字
     */
    private static final String[] NUMBERS = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    /**
     * 整数部分的单位
     */
    private static final String[] IUNIT = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰",
            "仟"};
    /**
     * 小数部分的单位
     */
    private static final String[] DUNIT = {"角", "分", "厘"};

    /**
     * 得到大写金额。
     */
    public static String toChinese(String str) {
        str = str.replaceAll(",", "");// 去掉","
        String integerStr;// 整数部分数字
        String decimalStr;// 小数部分数字

        // 初始化：分离整数部分和小数部分
        if (str.indexOf(".") > 0) {
            integerStr = str.substring(0, str.indexOf("."));
            decimalStr = str.substring(str.indexOf(".") + 1);
        } else if (str.indexOf(".") == 0) {
            integerStr = "";
            decimalStr = str.substring(1);
        } else {
            integerStr = str;
            decimalStr = "";
        }
        // integerStr去掉首0，不必去掉decimalStr的尾0(超出部分舍去)
        if (!integerStr.equals("")) {
            integerStr = Long.toString(Long.parseLong(integerStr));
            if (integerStr.equals("0")) {
                integerStr = "";
            }
        }
        // overflow超出处理能力，直接返回
        if (integerStr.length() > IUNIT.length) {
            System.out.println(str + ":超出处理能力");
            return str;
        }

        int[] integers = toArray(integerStr);// 整数部分数字
        boolean isMust5 = isMust5(integerStr);// 设置万单位
        int[] decimals = toArray(decimalStr);// 小数部分数字
        return getChineseInteger(integers, isMust5) + getChineseDecimal(decimals);
    }

    /**
     * 整数部分和小数部分转换为数组，从高位至低位
     */
    private static int[] toArray(String number) {
        int[] array = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            array[i] = Integer.parseInt(number.substring(i, i + 1));
        }
        return array;
    }

    /**
     * 得到中文金额的整数部分。
     */
    private static String getChineseInteger(int[] integers, boolean isMust5) {
        StringBuffer chineseInteger = new StringBuffer("");
        int length = integers.length;
        for (int i = 0; i < length; i++) {
            // 0出现在关键位置：1234(万)5678(亿)9012(万)3456(元)
            // 特殊情况：10(拾元、壹拾元、壹拾万元、拾万元)
            String key = "";
            if (integers[i] == 0) {
                if ((length - i) == 13)// 万(亿)(必填)
                    key = IUNIT[4];
                else if ((length - i) == 9)// 亿(必填)
                    key = IUNIT[8];
                else if ((length - i) == 5 && isMust5)// 万(不必填)
                    key = IUNIT[4];
                else if ((length - i) == 1)// 元(必填)
                    key = IUNIT[0];
                // 0遇非0时补零，不包含最后一位
                if ((length - i) > 1 && integers[i + 1] != 0)
                    key += NUMBERS[0];
            }
            chineseInteger.append(integers[i] == 0 ? key : (NUMBERS[integers[i]] + IUNIT[length - i - 1]));
        }
        return chineseInteger.toString();
    }

    /**
     * 得到中文金额的小数部分。
     */
    private static String getChineseDecimal(int[] decimals) {

        StringBuilder chineseDecimal = new StringBuilder();

        for (int i = 0; i < decimals.length; i++) {
            // 舍去3位小数之后的
            if (i == 3)
                break;
            chineseDecimal.append(decimals[i] == 0 ? "" : (NUMBERS[decimals[i]] + DUNIT[i]));
        }

        return chineseDecimal.toString();
    }

    /**
     * 判断第5位数字的单位"万"是否应加。
     */
    private static boolean isMust5(String integerStr) {
        int length = integerStr.length();
        if (length > 4) {
            String subInteger;

            if (length > 8) {
                // 取得从低位数，第5到第8位的字串
                subInteger = integerStr.substring(length - 8, length - 4);
            } else {
                subInteger = integerStr.substring(0, length - 4);
            }
            return Integer.parseInt(subInteger) > 0;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String number = "1.23";
        System.out.println(number + " " + toChinese(number));
        number = "1234567890123456.123";
        System.out.println(number + " " + toChinese(number));
        number = "0.0798";
        System.out.println(number + " " + toChinese(number));
        number = "10,001,000.09";
        System.out.println(number + " " + toChinese(number));
        number = "01.107700";
        System.out.println(number + " " + toChinese(number));
    }

    //首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return Character.toLowerCase(s.charAt(0)) + s.substring(1);
    }

    //首字母转大写
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    /**
     * 从字符串中解析出一个数字
     *
     * @param origin
     * @return
     */
    public static Double parseNumber(String origin) {

        StringBuilder amount = new StringBuilder();

        for (int i = 0; i < origin.length(); i++) {

            char c = origin.charAt(i);

            String value = String.valueOf(c);

            if (".".equals(value) && i != 0) {
                amount.append(".");
                continue;
            }

            boolean digits = NumberUtils.isDigits(value);

            if (!digits && i != 0 && !"".equals(amount.toString())) {
                return NumberUtils.toDouble(amount.toString());
            }

            if (digits) {
                amount.append(value);
            }

        }

        //
        if ("".equals(amount.toString())) {
            return 0D;
        }

        return NumberUtils.toDouble(amount.toString());
    }
}
