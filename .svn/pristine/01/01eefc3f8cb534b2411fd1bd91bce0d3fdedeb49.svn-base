package bonree;

import bonree.pipeline.IJedisPipeline;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 *
 * @date 2016-6-2 下午04:06:05
 * @Author: <a href=mailto:zhangnl@bonree.com>张念礼</a>
 * @Title: IJedisProxy.java
 * @Package bonree
 * Description: redis代理接口
 * Version: 1.0
 ******************************************************************************/
public interface IJedis {

    public Object initPool(String clusterNode);

    public Object initPool(String clusterNode, String password);

    public void getResource(Object poolObj);

    public void returnResource();

    public String set(String key, String value);

    public String set(byte[] key, byte[] value);

    public long append(String key, String value);

    public long append(byte[] keyByte, byte[] valueByte);

    public long bitcount(String key, long start, long end);

    public long bitcount(byte[] key, long start, long end);

    public long bitcount(String key);

    public long bitcount(byte[] key);

    public void close() throws IOException;

    public long incr(byte[] key);

    public long incr(String key);

    public long incrBy(String key, long integer);

    public long incrBy(byte[] key, long integer);

    public long decr(byte[] key);

    public long decr(String key);

    public long decrBy(byte[] key, long integer);

    public long decrBy(String key, long integer);

    public long del(byte[] key);

    public long del(String key);

    public boolean exists(byte[] key);

    public boolean exists(String key);

    public String echo(String arg);

    public byte[] echo(byte[] arg);

    public long expire(byte[] key, int seconds);

    public long expire(String key, int seconds);

    public long expireAt(byte[] key, long unixTime);

    public long expireAt(String key, long unixTime);

    public byte[] get(byte[] key);

    public String get(String key);

    public long hdel(byte[] key, byte[]... field);

    public long hdel(String key, String... field);

    public boolean hexists(byte[] key, byte[] field);

    public boolean hexists(String key, String field);

    public byte[] hget(byte[] key, byte[] field);

    public String hget(String key, String field);

    public Map<byte[], byte[]> hgetAll(byte[] key);

    public Map<String, String> hgetAll(String key);

    public Set<byte[]> hkeys(byte[] key);

    public Set<String> hkeys(String key);

    public long hlen(byte[] key);

    public long hlen(String key);

    public List<String> hmget(String key, String... fields);

    public List<byte[]> hmget(byte[] key, byte[]... fields);

    public String hmset(byte[] key, Map<byte[], byte[]> hash);

    public String hmset(String key, Map<String, String> hash);

    public long hset(byte[] key, byte[] field, byte[] value);

    public long hset(String key, String field, String value);

    public long hsetnx(byte[] key, byte[] field, byte[] value);

    public long hsetnx(String key, String field, String value);

    public long setnx(String key, String value);

    public long setnx(byte[] key, byte[] value);

    public long llen(byte[] key);

    public long llen(String key);

    public byte[] lpop(byte[] key);

    public String lpop(String key);

    public long lpush(byte[] key, byte[]... args);

    public long lpush(String key, String... args);

    public long lpushx(byte[] key, byte[]... arg);

    public long lpushx(String key, String... arg);

    public List<byte[]> lrange(byte[] key, long start, long end);

    public List<String> lrange(String key, long start, long end);

    public long lrem(byte[] key, long count, byte[] value);

    public long lrem(String key, long count, String value);

    public String lset(byte[] key, long index, byte[] value);

    public String lset(String key, long index, String value);

    public String ltrim(byte[] key, long start, long end);

    public String ltrim(String key, long start, long end);

    public long persist(byte[] key);

    public long persist(String key);

    public long pexpire(byte[] key, long milliseconds);

    public long pexpire(String key, long milliseconds);

    public long pexpireAt(byte[] key, long millisecondsTimestamp);

    public long pexpireAt(String key, long millisecondsTimestamp);

    public long pfadd(byte[] key, byte[]... elements);

    public long pfadd(String key, String... elements);

    public byte[] rpop(byte[] key);

    public String rpop(String key);

    public long rpush(byte[] key, byte[]... args);

    public long rpush(String key, String... string);

    public long rpushx(byte[] key, byte[]... arg);

    public long rpushx(String key, String... string);

    public long sadd(byte[] key, byte[]... member);

    public long sadd(String key, String... member);

    public long scard(byte[] key);

    public long scard(String key);

    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time);

    public String set(String key, String value, String nxxx, String expx, long time);

    public Boolean setbit(byte[] key, long offset, boolean value);

    public Boolean setbit(byte[] key, long offset, byte[] value);

    public Boolean setbit(String key, long offset, boolean value);

    public Boolean setbit(String key, long offset, String value);

    public String setex(byte[] key, int seconds, byte[] value);

    public String setex(String key, int seconds, String value);

    public long setrange(byte[] key, long offset, byte[] value);

    public long setrange(String key, long offset, String value);

    public Set<byte[]> spop(byte[] key, long count);

    public byte[] spop(byte[] key);

    public Set<String> spop(String key, long count);

    public String spop(String key);

    public long ttl(byte[] key);

    public long ttl(String key);

    public String type(byte[] key);

    public String type(String key);

    public long zadd(byte[] key, double score, byte[] member);

    public long zadd(byte[] key, Map<byte[], Double> scoreMembers);

    public long zadd(String key, double score, String member);

    public long zadd(String key, Map<String, Double> scoreMembers);

    public long zcard(byte[] key);

    public long zcard(String key);

    public Set<byte[]> zrange(byte[] key, long start, long end);

    public Set<String> zrange(String key, long start, long end);

    public boolean sismember(String key, String member);

    public boolean sismember(byte[] key, byte[] member);

    public byte[] lindex(byte[] key, long index);

    public String lindex(String key, long index);

    public String getSet(String key, String newValue);

    public byte[] getSet(byte[] key, byte[] newValue);

    public IJedisPipeline pipeline();

    public Set<String> smembers(String key);

    public Set<byte[]> smembers(byte[] key);

}
