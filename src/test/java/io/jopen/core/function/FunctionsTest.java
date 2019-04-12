package io.jopen.core.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

        Map<String, Integer> map = new HashMap<String, Integer>() {
            //构造一个测试用Map集合
            {
                put("love", 1);
                put("miss", 2);
            }
        };

        Function<String, Integer> function = Functions.forMap(map);

        Integer result = function.apply("love");

        System.err.println(result);
    }
}
