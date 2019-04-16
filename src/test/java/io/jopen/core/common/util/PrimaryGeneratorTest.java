package io.jopen.core.common.util;

import io.jopen.core.common.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author maxuefeng
 */
public class PrimaryGeneratorTest {

    /**
     * @see io.jopen.core.common.Util.PrimaryGenerator  存在BUG，流水账号存在重复
     */
    @Test
    public void testSimple() {

        //      869150
        //      1000000

        //      868772
        //      1000000

        Set<String> set = new HashSet<>(10000000);

        List<String> list = new ArrayList<>(10000000);

        for (int i = 0; i < 1000000; i++) {
            String sn = Util.PrimaryGenerator.getInstance().sn();

            set.add(sn);
            list.add(sn);

            System.err.println(sn);
        }

        System.err.println(set.size());
        System.err.println(list.size());
    }
}
