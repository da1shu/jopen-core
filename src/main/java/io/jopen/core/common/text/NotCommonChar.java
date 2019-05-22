package io.jopen.core.common.text;

/**
 * 图像识别结果将不常用的字符替换掉
 *
 * @author maxuefeng
 */
public enum NotCommonChar {

    C1("@"),
    C2("#"),
    C3("《"),
    C4("》");

    private String s;

    NotCommonChar(String s) {
        this.s = s;
    }
}
