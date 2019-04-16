package io.jopen.core.common.time;

import io.jopen.core.common.Formatter;
import io.jopen.core.common.LocalDateTimeUtil;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author maxuefeng
 */
public class FormatterTest {

    @Test
    public void testFormatLocalDateTime() {

        System.err.println(Formatter.f(LocalDateTimeUtil.toLocalDateTime(new Date().getTime()), Formatter.P.P6));
    }
}
