package bonree.poolimpl;

import bonree.impl.Jedis28Impl;
import bonree.utils.ProxyUtils;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 *
 * @date 2016-6-5 下午04:27:26
 * @Author: <a href=mailto:zhangnl@bonree.com>张念礼</a>
 * @Title: JedisPool28Impl.java
 * @Package bonree.poolimpl
 * Description: REDIS2.8连接池实现类
 * Version: 1.0
 ******************************************************************************/
public class JedisPool28Impl extends Jedis28Impl {

    private static final Lock lock = new ReentrantLock();

    /**
     * REDIS共享连接池实例
     */
    private static ShardedJedisPool jedisPool;

    /**
     * 概述：初始REDIS2.8版本连接池
     *
     * @param jedisInfoList
     * @return ShardedJedisPool
     * @Title: initPool
     * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
     */
    public ShardedJedisPool initPool(String jedisInfoList) {
        if (jedisPool == null) {
            lock.lock();
            try {
                if (jedisPool == null) {
                    JedisPoolConfig config = new JedisPoolConfig();// Jedis池配置
                    config.setMaxTotal(1024);            // 最大活动的对象个数
                    config.setMaxIdle(1000 * 60);        // 对象最大空闲时间
                    config.setMaxWaitMillis(1000 * 180); // 获取对象时最大等待时间
                    config.setTestOnBorrow(true);
                    jedisPool = new ShardedJedisPool(config, getHostAndPort(jedisInfoList));
                }
            } finally {
                lock.unlock();
            }
        }
        return jedisPool;
    }

    /**
     * 概述：初始化
     *
     * @param jedisInfoList
     * @param password
     * @return
     */
    public ShardedJedisPool initPool(String jedisInfoList, String password) {
        throw new UnsupportedOperationException("codis 2.8 does not support password");
    }

    /**
     * 概述：处理共享连接池地址
     *
     * @param clusterNode
     * @return List<JedisShardInfo>
     * @Title: getHostAndPort
     * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
     */
    public List<JedisShardInfo> getHostAndPort(String clusterNode) {
        List<JedisShardInfo> setList = new ArrayList<JedisShardInfo>();
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
                setList.add(new JedisShardInfo(hostAdd[0], Integer.valueOf(hostAdd[1]), 180 * 1000));
            }
        }
        return setList;
    }
}
