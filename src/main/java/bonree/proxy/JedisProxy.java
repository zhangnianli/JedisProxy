package bonree.proxy;

import bonree.IJedis;
import bonree.poolimpl.JedisPool28Impl;
import bonree.poolimpl.JedisPool30Impl;
import bonree.utils.ProxyUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 *
 * @date 2016-6-2 下午04:07:33
 * @Author: <a href=mailto:zhangnl@bonree.com>张念礼</a>
 * @Title: JedisProxy.java
 * @Package bonree
 * Description: JEDIS客户端代理
 * Version: 1.0
 ******************************************************************************/
public class JedisProxy {

    /**
     * redis的类型，取值2.8或者3.0
     */
    public static final String REDIS_TYPE = "REDIS_TYPE";

    /**
     * 重试的次数
     */
    public static final String RETRY_COUNT = "RETRY_COUNT";

    /**
     * 重试睡眠时间
     */
    public static final String SLEEP_TIME_MS = "SLEEP_TIME_MS";

    /**
     * key前缀
     */
    public static final String KEY_PREFIX = "KEY_PREFIX";

    /**
     * redis 集群的信息，ip:port,ip:port
     */
    public static final String CLUSTER_NODES = "CLUSTER_NODES";

    /**
     * 密码
     */
    public static final String PASSWORD = "PASSWORD";

    private static final String[] keys = {REDIS_TYPE, RETRY_COUNT, SLEEP_TIME_MS, KEY_PREFIX, CLUSTER_NODES, PASSWORD};

    private static final String redis28 = "2.8";//REDIS2.8版本
    private static final String redis30 = "3.0";//REDIS3.0版本
    private int retryCount = 3;                //重试次数
    private long sleepTime = 10000;                //重试间隔
    private String keyPrefix = "";                //key前缀,默认为""
    private Object poolObj;                        //连接池对象
    private IJedis proxy;

    /**
     * 实例初始化
     *
     * @param clusterNodes REDIS节点集合,多个以","分隔
     * @return
     */
    public JedisProxy(String clusterNodes) {
        instance(redis30, clusterNodes, retryCount, sleepTime, keyPrefix, true);
    }

    /**
     * 实例初始化
     *
     * @param type         redis版本: 2.8 or 3.0
     * @param clusterNodes REDIS节点集合,多个以","分隔
     * @return
     */
    public JedisProxy(String type, String clusterNodes) {
        instance(type, clusterNodes, retryCount, sleepTime, keyPrefix, true);
    }

    /**
     * 实例初始化
     *
     * @param type         redis版本: 2.8 or 3.0
     * @param clusterNodes REDIS节点集合,多个以","分隔
     * @param keyPrefix    key前缀
     * @return
     */
    public JedisProxy(String type, String clusterNodes, String keyPrefix) {
        instance(type, clusterNodes, retryCount, sleepTime, keyPrefix, true);
    }
    
    /**
     * 实例初始化
     *
     * @param type         redis版本: 2.8 or 3.0
     * @param clusterNodes REDIS节点集合,多个以","分隔
     * @param keyPrefix    key前缀
     * @param password     redis密码
     * @return
     */
    public JedisProxy(String type, String clusterNodes, String keyPrefix, String password) {
        if ("".equals(password) || password == null) {            
            instance(type, clusterNodes, retryCount, sleepTime, keyPrefix, true);
        } else {            
            instance(type, clusterNodes, retryCount, sleepTime, keyPrefix, true, password);            
        }
    }

    public JedisProxy(Map<String, String> config) {
        checkVaild(config);
        String type = config.containsKey(REDIS_TYPE) ? config.get(REDIS_TYPE) : redis30;
        String clusterNodes = config.get(CLUSTER_NODES);
        int reCount = config.containsKey(RETRY_COUNT) ? Integer.parseInt(config.get(RETRY_COUNT)) : retryCount;
        long sleep = config.containsKey(SLEEP_TIME_MS) ? Integer.parseInt(config.get(SLEEP_TIME_MS)) : sleepTime;
        String prefix = config.containsKey(KEY_PREFIX) ? config.get(KEY_PREFIX) : keyPrefix;
        boolean initConn = true;
        if (config.containsKey(PASSWORD)) {
            String password = config.get(PASSWORD);
            instance(type, clusterNodes, reCount, sleep, prefix, initConn, password);
        } else {
            instance(type, clusterNodes, reCount, sleep, prefix, initConn);
        }
    }

    /**
     * 实例初始化
     *
     * @param type         redis版本: 2.8 or 3.0
     * @param clusterNodes REDIS节点集合,多个以","分隔
     * @param prefix       key前缀
     * @param initConn     是否初始连接
     * @return
     */
    public JedisProxy(String type, String clusterNodes, String prefix, boolean initConn) {
        instance(type, clusterNodes, retryCount, retryCount, prefix, initConn);
    }

    /**
     * 实例初始化
     *
     * @param type         redis版本: 2.8 or 3.0
     * @param clusterNodes REDIS节点集合,多个以","分隔
     * @param reCount      重试次数
     * @param sleep        重试间隔时间
     * @param prefix       key前缀
     * @return
     */
    public JedisProxy(String type, String clusterNodes, int reCount, long sleep, String prefix) {
        instance(type, clusterNodes, reCount, sleep, prefix, true);
    }

    /**
     * 实例初始化
     *
     * @param type         redis版本: 2.8 or 3.0
     * @param clusterNodes REDIS节点集合,多个以","分隔
     * @param reCount      重试次数
     * @param sleep        重试间隔时间
     * @param prefix       key前缀
     * @param initConn     是否初始连接
     * @return
     */
    private void instance(String type, String clusterNodes, int reCount, long sleep, String prefix, boolean initConn) {
        if (redis28.equals(type)) {
            proxy = new JedisPool28Impl();
        } else { //默认REDIS3.0版本
            proxy = new JedisPool30Impl();
        }
        keyPrefix = prefix;
        sleepTime = sleep;
        retryCount = reCount;
        poolObj = proxy.initPool(clusterNodes);
        if (initConn) {
            proxy.getResource(poolObj);
        }
    }


    /**
     * 实例初始化
     *
     * @param type         redis版本: 2.8 or 3.0
     * @param clusterNodes REDIS节点集合,多个以","分隔
     * @param reCount      重试次数
     * @param sleep        重试间隔时间
     * @param prefix       key前缀
     * @param initConn     是否初始连接
     * @param password     密码
     * @return
     */
    private void instance(String type, String clusterNodes, int reCount, long sleep, String prefix, boolean initConn, String password) {
        if (redis28.equals(type)) {
            proxy = new JedisPool28Impl();
        } else { //默认REDIS3.0版本
            proxy = new JedisPool30Impl();
        }
        keyPrefix = prefix;
        sleepTime = sleep;
        retryCount = reCount;
        poolObj = proxy.initPool(clusterNodes, password);
        if (initConn) {
            proxy.getResource(poolObj);
        }
    }


    /**
     * 概述：初始一个连接(注:2.8版本时使用,且initConn设置为false)
     *
     * @Title: initResource
     * void
     * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
     */
    public void initResource() {
        proxy.getResource(poolObj);
    }

    /**
     * 概述：释放资源
     *
     * @Title: close
     * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
     */
    public void close() {
        proxy.returnResource();
    }

    /**
     * 概述：添加key前缀
     *
     * @param key
     * @return String
     * @Title: getKey
     * @user <a href=mailto:wangnk@bonree.com>王宁柯</a>
     */
    private String getKey(String key) {
        return keyPrefix + key;
    }

    /**
     * 概述：添加key前缀  byte[]
     *
     * @param keyByte
     * @return byte[]
     * @Title: getKey
     * @user <a href=mailto:wangnk@bonree.com>王宁柯</a>
     */
    private byte[] getKey(byte[] keyByte) {
        try {
            byte[] prefix = keyPrefix.getBytes("utf-8");
            return ProxyUtils.combineByte(prefix, keyByte);
        } catch (Exception e) {
            e.printStackTrace();
            return keyByte;
        }
    }

    public long append(byte[] key, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.append(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.append(getKey(key), value);
    }

    public long append(String key, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.append(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.append(getKey(key), value);
    }

    public long bitcount(byte[] key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.bitcount(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.bitcount(getKey(key), start, end);
    }

    public long bitcount(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.bitcount(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.bitcount(getKey(key));
    }

    public long bitcount(String key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.bitcount(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }

        }
        return proxy.bitcount(getKey(key), start, end);
    }

    public long bitcount(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.bitcount(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.bitcount(getKey(key));
    }

    public long decr(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.decr(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.decr(getKey(key));
    }

    public long decr(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.decr(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.decr(getKey(key));
    }

    public long decrBy(byte[] key, long integer) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.decrBy(getKey(key), integer);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.decrBy(getKey(key), integer);
    }

    public long decrBy(String key, long integer) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.decrBy(getKey(key), integer);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.decrBy(getKey(key), integer);
    }

    public long del(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.del(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.del(getKey(key));
    }

    public long synDel(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                int index = 0;
                while (proxy.exists(getKey(key))) {
                    index++;
                    System.out.println(new String(getKey(key)) + ":" + index);
                    proxy.del(getKey(key));
                }
                return 1l;
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.del(getKey(key));
    }

    public long del(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.del(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.del(getKey(key));
    }

    public byte[] echo(byte[] arg) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.echo(arg);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.echo(arg);
    }

    public String echo(String string) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.echo(string);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.echo(string);
    }

    public boolean equals(Object arg0) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.equals(arg0);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.equals(arg0);
    }

    public boolean exists(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.exists(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.exists(getKey(key));
    }

    public boolean exists(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.exists(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.exists(getKey(key));
    }

    public long expire(byte[] key, int seconds) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.expire(getKey(key), seconds);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.expire(getKey(key), seconds);
    }

    public long expire(String key, int seconds) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.expire(getKey(key), seconds);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.expire(getKey(key), seconds);
    }

    public long expireAt(byte[] key, long unixTime) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.expireAt(getKey(key), unixTime);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.expireAt(getKey(key), unixTime);
    }

    public long expireAt(String key, long unixTime) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.expireAt(getKey(key), unixTime);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.expireAt(getKey(key), unixTime);
    }

    public byte[] get(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.get(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.get(getKey(key));
    }

    public String get(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.get(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.get(getKey(key));
    }

    public int hashCode() {
        return proxy.hashCode();
    }

    public long hdel(byte[] key, byte[]... field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hdel(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hdel(getKey(key), field);
    }

    public long hdel(String key, String... field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hdel(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hdel(getKey(key), field);
    }

    public boolean hexists(byte[] key, byte[] field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hexists(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hexists(getKey(key), field);
    }

    public boolean hexists(String key, String field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hexists(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hexists(getKey(key), field);
    }

    public byte[] hget(byte[] key, byte[] field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hget(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hget(getKey(key), field);
    }

    public String hget(String key, String field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hget(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hget(getKey(key), field);
    }

    public Map<byte[], byte[]> hgetAll(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hgetAll(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hgetAll(getKey(key));
    }

    public Map<String, String> hgetAll(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hgetAll(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hgetAll(getKey(key));
    }

    public Set<byte[]> hkeys(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hkeys(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hkeys(getKey(key));
    }

    public Set<String> hkeys(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hkeys(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hkeys(getKey(key));
    }

    public long hlen(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hlen(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hlen(getKey(key));
    }

    public long hlen(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hlen(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hlen(getKey(key));
    }

    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hmget(getKey(key), fields);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hmget(getKey(key), fields);
    }

    public List<String> hmget(String key, String... fields) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hmget(getKey(key), fields);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hmget(getKey(key), fields);
    }

    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hmset(getKey(key), hash);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hmset(getKey(key), hash);
    }

    public String hmset(String key, Map<String, String> hash) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hmset(getKey(key), hash);
            } catch (Exception e) {
                sleep();
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hmset(getKey(key), hash);
    }

    public long hset(byte[] key, byte[] field, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hset(getKey(key), field, value);
            } catch (Exception e) {
                sleep();
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hset(getKey(key), field, value);
    }

    public long hset(String key, String field, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hset(getKey(key), field, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hset(getKey(key), field, value);
    }

    public long hsetnx(byte[] key, byte[] field, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hsetnx(getKey(key), field, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hsetnx(getKey(key), field, value);
    }

    public long hsetnx(String key, String field, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.hsetnx(getKey(key), field, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.hsetnx(getKey(key), field, value);
    }

    public long incr(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.incr(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.incr(getKey(key));
    }

    public long incr(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.incr(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.incr(getKey(key));
    }

    public long incrBy(byte[] key, long integer) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.incrBy(getKey(key), integer);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.incrBy(getKey(key), integer);
    }

    public long incrBy(String key, long integer) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.incrBy(getKey(key), integer);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.incrBy(getKey(key), integer);
    }

    public long llen(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.llen(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.llen(getKey(key));
    }

    public long llen(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.llen(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.llen(getKey(key));
    }

    public byte[] lpop(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lpop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lpop(getKey(key));
    }

    public String lpop(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lpop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lpop(getKey(key));
    }

    public long lpush(byte[] key, byte[]... args) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lpush(getKey(key), args);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lpush(getKey(key), args);
    }

    public long lpush(String key, String... string) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lpush(getKey(key), string);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lpush(getKey(key), string);
    }

    public long lpushx(byte[] key, byte[]... arg) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lpushx(getKey(key), arg);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lpushx(getKey(key), arg);
    }

    public long lpushx(String key, String... string) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lpushx(getKey(key), string);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lpushx(getKey(key), string);
    }

    public List<byte[]> lrange(byte[] key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lrange(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lrange(getKey(key), start, end);
    }

    public List<String> lrange(String key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lrange(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lrange(getKey(key), start, end);
    }

    public long lrem(byte[] key, long count, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lrem(getKey(key), count, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lrem(getKey(key), count, value);
    }

    public long lrem(String key, long count, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lrem(getKey(key), count, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lrem(getKey(key), count, value);
    }

    public String lset(byte[] key, long index, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lset(getKey(key), index, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lset(getKey(key), index, value);
    }

    public String lset(String key, long index, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lset(getKey(key), index, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lset(getKey(key), index, value);
    }

    public String ltrim(byte[] key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.ltrim(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.ltrim(getKey(key), start, end);
    }

    public String ltrim(String key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.ltrim(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.ltrim(getKey(key), start, end);
    }

    public long persist(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.persist(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.persist(getKey(key));
    }

    public long persist(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.persist(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.persist(getKey(key));
    }

    public long pexpire(byte[] key, long milliseconds) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.pexpire(getKey(key), milliseconds);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.pexpire(getKey(key), milliseconds);
    }

    public long pexpire(String key, long milliseconds) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.pexpire(getKey(key), milliseconds);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.pexpire(getKey(key), milliseconds);
    }

    public long pexpireAt(byte[] key, long millisecondsTimestamp) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.pexpireAt(getKey(key), millisecondsTimestamp);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.pexpireAt(getKey(key), millisecondsTimestamp);
    }

    public long pexpireAt(String key, long millisecondsTimestamp) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.pexpireAt(getKey(key), millisecondsTimestamp);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.pexpireAt(getKey(key), millisecondsTimestamp);
    }

    public long pfadd(byte[] key, byte[]... elements) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.pfadd(getKey(key), elements);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.pfadd(getKey(key), elements);
    }

    public long pfadd(String key, String... elements) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.pfadd(getKey(key), elements);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.pfadd(getKey(key), elements);
    }


    public byte[] rpop(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.rpop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.rpop(getKey(key));
    }

    public String rpop(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.rpop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.rpop(getKey(key));
    }


    public long rpush(byte[] key, byte[]... args) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.rpush(getKey(key), args);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.rpush(getKey(key), args);
    }

    public long rpush(String key, String... string) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.rpush(getKey(key), string);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.rpush(getKey(key), string);
    }

    public long rpushx(byte[] key, byte[]... arg) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.rpushx(getKey(key), arg);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.rpushx(getKey(key), arg);
    }

    public long rpushx(String key, String... string) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.rpushx(getKey(key), string);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.rpushx(getKey(key), string);
    }

    public long sadd(byte[] key, byte[]... member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.sadd(getKey(key), member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.sadd(getKey(key), member);
    }

    public long sadd(String key, String... member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.sadd(getKey(key), member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.sadd(getKey(key), member);
    }

    public long scard(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.scard(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.scard(getKey(key));
    }

    public long scard(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.scard(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.scard(getKey(key));
    }

    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.set(getKey(key), value, nxxx, expx, time);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.set(getKey(key), value, nxxx, expx, time);
    }

    public String set(byte[] key, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.set(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.set(getKey(key), value);
    }

    public String set(String key, String value, String nxxx, String expx, long time) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.set(getKey(key), value, nxxx, expx, time);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.set(getKey(key), value, nxxx, expx, time);
    }

    public String set(String key, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.set(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.set(getKey(key), value);
    }

    public Boolean setbit(byte[] key, long offset, boolean value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.setbit(getKey(key), offset, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.setbit(getKey(key), offset, value);
    }

    public Boolean setbit(byte[] key, long offset, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.setbit(getKey(key), offset, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.setbit(getKey(key), offset, value);
    }

    public Boolean setbit(String key, long offset, boolean value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.setbit(getKey(key), offset, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.setbit(getKey(key), offset, value);
    }

    public Boolean setbit(String key, long offset, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.setbit(getKey(key), offset, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.setbit(getKey(key), offset, value);
    }

    public String setex(byte[] key, int seconds, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.setex(getKey(key), seconds, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.setex(getKey(key), seconds, value);
    }

    public String setex(String key, int seconds, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.setex(getKey(key), seconds, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.setex(getKey(key), seconds, value);
    }

    public long setnx(byte[] key, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.setnx(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.setnx(getKey(key), value);
    }

    public long setnx(String key, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.setnx(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.setnx(getKey(key), value);
    }

    public long setrange(byte[] key, long offset, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.setrange(getKey(key), offset, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.setrange(getKey(key), offset, value);
    }

    public long setrange(String key, long offset, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.setrange(getKey(key), offset, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.setrange(getKey(key), offset, value);
    }

    public Set<byte[]> spop(byte[] key, long count) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.spop(getKey(key), count);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.spop(getKey(key), count);
    }

    public byte[] spop(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.spop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.spop(getKey(key));
    }

    public Set<String> spop(String key, long count) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.spop(getKey(key), count);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.spop(getKey(key), count);
    }

    public String spop(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.spop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.spop(getKey(key));
    }

    public String toString() {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.toString();
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.toString();
    }

    public long ttl(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.ttl(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.ttl(getKey(key));
    }

    public long ttl(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.ttl(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.ttl(getKey(key));
    }

    public String type(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.type(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.type(getKey(key));
    }

    public String type(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.type(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.type(getKey(key));
    }

    public long zadd(byte[] key, double score, byte[] member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.zadd(getKey(key), score, member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.zadd(getKey(key), score, member);
    }

    public long zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.zadd(getKey(key), scoreMembers);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.zadd(getKey(key), scoreMembers);
    }

    public long zadd(String key, double score, String member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.zadd(getKey(key), score, member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.zadd(getKey(key), score, member);
    }

    public long zadd(String key, Map<String, Double> scoreMembers) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.zadd(getKey(key), scoreMembers);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.zadd(getKey(key), scoreMembers);
    }

    public long zcard(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.zcard(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.zcard(getKey(key));
    }

    public long zcard(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.zcard(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.zcard(getKey(key));
    }

    public Set<byte[]> zrange(byte[] key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.zrange(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.zrange(getKey(key), start, end);
    }

    public Set<String> zrange(String key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.zrange(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.zrange(getKey(key), start, end);
    }

    public Boolean sismember(String key, String member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.sismember(getKey(key), member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.sismember(getKey(key), member);
    }

    public Boolean sismember(byte[] key, byte[] member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.sismember(getKey(key), member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.sismember(getKey(key), member);
    }

    public byte[] lindex(byte[] key, long index) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lindex(getKey(key), index);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lindex(getKey(key), index);
    }

    public String lindex(String key, long index) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.lindex(getKey(key), index);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.lindex(getKey(key), index);
    }

    public String getSet(String key, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.getSet(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.getSet(getKey(key), value);
    }

    public byte[] getSet(byte[] key, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.getSet(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.getSet(getKey(key), value);
    }

    private void sleep() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public JedisPipelineProxy pipeline() {
        return new JedisPipelineProxy(retryCount, sleepTime, keyPrefix, proxy.pipeline());
    }

    public Set<String> smembers(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.smembers(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.smembers(getKey(key));
    }

    public Set<byte[]> smembers(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return proxy.smembers(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return proxy.smembers(getKey(key));
    }

    private void checkVaild(Map<String, String> config) {
        if (config == null) {
            throw new NullPointerException("config map is null,please init it");
        }
        if (config.isEmpty()) {
            throw new IllegalArgumentException("config map is empty,please init it");
        }
        if (!config.containsKey(CLUSTER_NODES)) {
            throw new IllegalArgumentException("config map must contain CLUSTER_NODES");
        }
        if (config.containsKey(REDIS_TYPE)) {
            String redisType = config.get(REDIS_TYPE);
            if (!redis30.equals(redisType) && !redis28.contains(redisType)) {
                throw new IllegalArgumentException("the value of REDIS_TYPE must be 2.8 or 3.0,but actually is " + redisType);
            }
        }
    }
}
