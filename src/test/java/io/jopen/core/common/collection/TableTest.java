package io.jopen.core.common.collection;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

import java.util.Map;

/**
 * @author maxuefeng
 * @see com.google.common.collect.Table
 */
public class TableTest {

    @Test
    public void testSimpleAPI() {

        Table<Object, Object, Double> table = HashBasedTable.create();

        table.put(1, 2, 3D);
        table.put(1, 2, 3D);
        table.put(1, 2, 3D);
        table.put(1, 2, 3D);

        Map<Object, Map<Object, Double>> objectMapMap = table.rowMap();
    }
}
