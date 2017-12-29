package bonree.poolimpl;

import bonree.impl.Jedis30Impl;
import bonree.utils.ProxyUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 *
 * @date 2016-6-5 下午04:27:58
 * @Author: <a href=mailto:zhangnl@bonree.com>张念礼</a>
 * @Title: JedisPool30Impl.java
 * @Package bonree.poolimpl
 * Description: REDIS3.0连接池实现类
 * Version: 1.0
 ******************************************************************************/
public class JedisPool30Impl extends Jedis30Impl {

    private static final Lock lock = new ReentrantLock();

    /**
     * Jedis集群客户端实例
     */
    private static JedisCluster jedisPool;

    /**
     * 概述：初始REDIS3.0版本集群
     *
     * @param clusterNode
     * @return Object
     * @Title: initPool
     * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
     */
    public JedisCluster initPool(String clusterNode) {
        if (jedisPool == null) {
            lock.lock();
            try {
                if (jedisPool == null) {
                    GenericObjectPoolConfig config = new GenericObjectPoolConfig();
                    config.setMaxTotal(500);    // 最大连接数
                    config.setMaxIdle(100);        // 池中保留的最大空闲连接数
                    config.setMinIdle(100);        // 池中保留的最小空闲连接数
                    config.setMaxWaitMillis(5 * 1000); // 最大等待时间
                    jedisPool = new JedisCluster(getHostAndPort(clusterNode), 300 * 1000, config);// 创建REDIS集群
                }
            } finally {
                lock.unlock();
            }
        }
        return jedisPool;
    }

    public JedisCluster initPool(String clusterNode, String password) {
        if (jedisPool == null) {
            lock.lock();
            try {
                if (jedisPool == null) {
                    GenericObjectPoolConfig config = new GenericObjectPoolConfig();
                    config.setMaxTotal(500);    // 最大连接数
                    config.setMaxIdle(100);        // 池中保留的最大空闲连接数
                    config.setMinIdle(100);        // 池中保留的最小空闲连接数
                    config.setMaxWaitMillis(5 * 1000); // 最大等待时间
                    jedisPool = new JedisCluster(getHostAndPort(clusterNode), 300 * 1000, 300 * 1000, 10, password, config);// 创建REDIS集群
                }
            } finally {
                lock.unlock();
            }
        }
        return jedisPool;
    }

    /**
     * 概述：处理集群连接地址
     *
     * @param clusterNode
     * @return Set<HostAndPort>
     * @Title: getHostAndPortSet
     * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
     */
    public static Set<HostAndPort> getHostAndPort(String clusterNode) {
        Set<HostAndPort> setList = new HashSet<HostAndPort>();
        if (clusterNode != null) {
            String[] hostArr = ProxyUtils.getSplit(clusterNode, ",");
            if (hostArr == null) {
                return setList;
            }
            String[] hostAdd = null;
            for (int i = 0; i < hostArr.length; i++) {
                hostAdd = ProxyUtils.getSplit(hostArr[i], ":");
                if (hostAdd == null || hostAdd.length != 2) {
                    continue;
                }
                setList.add(new HostAndPort(hostAdd[0], Integer.valueOf(hostAdd[1])));
            }
        }
        return setList;
    }

}
