package io.jopen.core.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.junit.Test;

/**
 * @author maxuefeng
 * @see java.util.function.Function
 * @see com.google.common.base.Functions
 */
public class FunctionsTest {

    @Test
    public void testSimpleAPI(){
        Function<Object, Object> identity = Functions.identity();

        Object a = identity.apply("a");

        System.out.println(a);
    }
}
