package io.jopen.core.common.text;

import org.apache.commons.lang3.StringUtils;

import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Collection;
import java.util.Enumeration;

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
     * 流水交易单号生成
     * [https://www.callicoder.com/distributed-unique-id-sequence-number-generator/]
     */
    public static class SequenceGenerator {

        // 64
        private static final int TOTAL_BITS = 64;

        //
        private static final int EPOCH_BITS = 42;

        //
        private static final int NODE_ID_BITS = 10;

        //
        private static final int SEQUENCE_BITS = 12;

        //
        private static final int maxNodeId = (int) (Math.pow(2, NODE_ID_BITS) - 1);

        //
        private static final int maxSequence = (int) (Math.pow(2, SEQUENCE_BITS) - 1);


        // Custom Epoch (January 1, 2015 Midnight UTC = 2015-01-01T00:00:00Z)
        private static final long CUSTOM_EPOCH = 1420070400000L;

        private final int nodeId;

        private volatile long lastTimestamp = -1L;

        private volatile long sequence = 0L;

        // Create SequenceGenerator with a nodeId
        public SequenceGenerator(int nodeId) {

            if (nodeId < 0 || nodeId > maxNodeId) {
                throw new IllegalArgumentException(String.format("NodeId must be between %d and %d", 0, maxNodeId));
            }
            this.nodeId = nodeId;
        }

        // Let SequenceGenerator generate a nodeId
        public SequenceGenerator() {
            this.nodeId = createNodeId();
        }


        public synchronized long nextId() {
            long currentTimestamp = timestamp();

            if (currentTimestamp < lastTimestamp) {
                throw new IllegalStateException("Invalid System Clock!");
            }

            if (currentTimestamp == lastTimestamp) {
                sequence = (sequence + 1) & maxSequence;
                if (sequence == 0) {
                    // Sequence Exhausted, wait till next millisecond.
                    currentTimestamp = waitNextMillis(currentTimestamp);
                }
            } else {
                // reset sequence to start with zero for the next millisecond
                sequence = 0;
            }

            lastTimestamp = currentTimestamp;

            long id = currentTimestamp << (TOTAL_BITS - EPOCH_BITS);
            id |= (nodeId << (TOTAL_BITS - EPOCH_BITS - NODE_ID_BITS));
            id |= sequence;
            return id;
        }


        // Get current timestamp in milliseconds, adjust for the custom epoch.
        private static long timestamp() {
            return Instant.now().toEpochMilli() - CUSTOM_EPOCH;
        }

        // Block and wait till next millisecond
        private long waitNextMillis(long currentTimestamp) {
            while (currentTimestamp == lastTimestamp) {
                currentTimestamp = timestamp();
            }
            return currentTimestamp;
        }

        private int createNodeId() {

            int nodeId;
            try {
                StringBuilder sb = new StringBuilder();
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterface = networkInterfaces.nextElement();
                    byte[] mac = networkInterface.getHardwareAddress();
                    if (mac != null) {
                        for (byte b : mac) {
                            sb.append(String.format("%02X", b));
                        }
                    }
                }
                nodeId = sb.toString().hashCode();
            } catch (Exception ex) {
                nodeId = (new SecureRandom().nextInt());
            }
            nodeId = nodeId & maxNodeId;
            return nodeId;
        }
    }
}
