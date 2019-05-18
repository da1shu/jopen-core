package io.jopen.core.common.collection;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author maxuefeng
 * @see com.google.common.collect.Table
 */
public class TableTest {

    @Test
    public void testSimpleAPI() {


        Table<Object, Object, Double> table = HashBasedTable.create();

        // {1={2=3.0, 3=3.0, 4=3.0, 5=3.0}}
        table.put(1, 2, 3D);
        table.put(1, 3, 3D);
        table.put(1, 4, 3D);
        table.put(1, 5, 3D);

        System.err.println(table);

        Predicate<Integer> p = (t) -> t >= 9;

    }
}
