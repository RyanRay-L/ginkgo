//package cn.ryanray.ginkgo.base.generator;
//
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.IdentifierGenerator;
//
//import java.io.Serializable;
//
///**
// * @Author: 雷磊
// * @Date: 2025/3/18 17:44
// */
//public class SnowflakeIdGenerator implements IdentifierGenerator {
//
////    private final long twepoch = 1288834974657L; // 起始时间戳（2010-11-04 09:42:54）
//    private final long twepoch = 1736524800000L; // 起始时间戳（2025-01-01 00:00:00）
//    private final long workerIdBits = 5L; // 机器ID占用的位数
//    private final long datacenterIdBits = 5L; // 数据中心ID占用的位数
//    private final long maxWorkerId = ~(-1L << workerIdBits); // 最大机器ID
//    private final long maxDatacenterId = ~(-1L << datacenterIdBits); // 最大数据中心ID
//    private final long sequenceBits = 12L; // 序列号占用的位数
//    private final long workerIdShift = sequenceBits; // 机器ID左移位数
//    private final long datacenterIdShift = sequenceBits + workerIdBits; // 数据中心ID左移位数
//    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits; // 时间戳左移位数
//    private final long sequenceMask = ~(-1L << sequenceBits); // 序列号掩码
//
//    private long workerId; // 机器ID
//    private long datacenterId; // 数据中心ID
//    private long sequence = 0L; // 序列号
//    private long lastTimestamp = -1L; // 上次生成ID的时间戳
//
//    public SnowflakeIdGenerator(long workerId, long datacenterId) {
//        if (workerId > maxWorkerId || workerId < 0) {
//            throw new IllegalArgumentException("Worker ID 必须介于 0 和 " + maxWorkerId + " 之间");
//        }
//        if (datacenterId > maxDatacenterId || datacenterId < 0) {
//            throw new IllegalArgumentException("Datacenter ID 必须介于 0 和 " + maxDatacenterId + " 之间");
//        }
//        this.workerId = workerId;
//        this.datacenterId = datacenterId;
//    }
//
//    public synchronized long nextId() {
//        long timestamp = timeGen();
//
//        if (timestamp < lastTimestamp) {
//            throw new RuntimeException("时钟回拨，拒绝生成ID");
//        }
//
//        if (timestamp == lastTimestamp) {
//            sequence = (sequence + 1) & sequenceMask;
//            if (sequence == 0) {
//                timestamp = tilNextMillis(lastTimestamp);
//            }
//        } else {
//            sequence = 0L;
//        }
//
//        lastTimestamp = timestamp;
//
//        return ((timestamp - twepoch) << timestampLeftShift)
//                | (datacenterId << datacenterIdShift)
//                | (workerId << workerIdShift)
//                | sequence;
//    }
//
//    private long tilNextMillis(long lastTimestamp) {
//        long timestamp = timeGen();
//        while (timestamp <= lastTimestamp) {
//            timestamp = timeGen();
//        }
//        return timestamp;
//    }
//
//    private long timeGen() {
//        return System.currentTimeMillis();
//    }
//
//    private static final SnowflakeIdGenerator INSTANCE = new SnowflakeIdGenerator(1, 1);
//
//    @Override
//    public Serializable generate(SharedSessionContractImplementor session, Object object) {
//        return INSTANCE.nextId();
//    }
//}