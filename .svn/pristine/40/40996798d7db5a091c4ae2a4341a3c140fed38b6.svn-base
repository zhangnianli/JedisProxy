package bonree.impl;

import bonree.IJedis;
import bonree.pipeline.IJedisPipeline;
import bonree.pipeline.Jedis28Pipeline;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 *
 * @date 2016-6-2 下午04:08:10
 * @Author: <a href=mailto:zhangnl@bonree.com>张念礼</a>
 * @Title: Jedis28Impl.java
 * @Package bonree
 * Description:
 * Version: 1.0
 ******************************************************************************/
public abstract class Jedis28Impl implements IJedis {

    /**
     * REDIS实例
     */
    private ShardedJedis jedis;

    @Override
    public IJedisPipeline pipeline() {
        return new Jedis28Pipeline(jedis.pipelined());
    }

    /**
     * 获取REDIS实例
     */
    public void getResource(Object poolObj) {
        jedis = ((ShardedJedisPool) poolObj).getResource();
    }

    /**
     * 概述：释放实例资源
     *
     * @Title: returnResource
     * void
     * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
     */
    public void returnResource() {
        jedis.close();
    }

    @Override
    public String set(String key, String value) {
        return jedis.set(key, value);
    }

    @Override
    public long append(String key, String value) {
        return jedis.append(key, value);
    }

    @Override
    public long append(byte[] keyByte, byte[] valueByte) {
        return jedis.append(keyByte, valueByte);
    }

    @Override
    public String set(byte[] key, byte[] value) {
        return jedis.set(key, value);
    }

    @Override
    public long bitcount(byte[] key, long start, long end) {
        return jedis.bitcount(key, start, end);
    }

    @Override
    public long bitcount(String key) {
        return jedis.bitcount(key);
    }

    @Override
    public long bitcount(byte[] key) {
        return jedis.bitcount(key);
    }

    @Override
    public long bitcount(String key, long start, long end) {
        return jedis.bitcount(key, start, end);
    }

    @Override
    public void close() {
        jedis.close();
    }

    @Override
    public long decr(byte[] key) {
        return jedis.decr(key);
    }

    @Override
    public long decr(String key) {
        return jedis.decr(key);
    }

    @Override
    public long decrBy(byte[] key, long integer) {
        return jedis.decrBy(key, integer);
    }

    @Override
    public long decrBy(String key, long integer) {
        return jedis.decrBy(key, integer);
    }

    @Override
    public long del(byte[] keys) {
        return jedis.del(keys);
    }

    @Override
    public long del(String keys) {
        return jedis.del(keys);
    }

    @Override
    public boolean exists(byte[] key) {
        return jedis.exists(key);
    }

    @Override
    public boolean exists(String key) {
        return jedis.exists(key);
    }

    @Override
    public String echo(String arg) {
        return jedis.echo(arg);
    }

    @Override
    public byte[] echo(byte[] arg) {
        return jedis.echo(arg);
    }

    @Override
    public long expire(byte[] key, int seconds) {
        return jedis.expire(key, seconds);
    }

    @Override
    public long expire(String key, int seconds) {
        return jedis.expire(key, seconds);
    }

    @Override
    public long expireAt(byte[] key, long unixTime) {
        return jedis.expireAt(key, unixTime);
    }

    @Override
    public long expireAt(String key, long unixTime) {
        return jedis.expireAt(key, unixTime);
    }

    @Override
    public byte[] get(byte[] key) {
        return jedis.get(key);
    }

    @Override
    public String get(String key) {
        return jedis.get(key);
    }

    @Override
    public long hdel(byte[] key, byte[]... field) {
        return jedis.hdel(key, field);
    }

    @Override
    public long hdel(String key, String... field) {
        return jedis.hdel(key, field);
    }

    @Override
    public boolean hexists(byte[] key, byte[] field) {
        return jedis.hexists(key, field);
    }

    @Override
    public boolean hexists(String key, String field) {
        return jedis.hexists(key, field);
    }

    @Override
    public byte[] hget(byte[] key, byte[] field) {
        return jedis.hget(key, field);
    }

    @Override
    public String hget(String key, String field) {
        return jedis.hget(key, field);
    }

    @Override
    public Map<byte[], byte[]> hgetAll(byte[] key) {
        return jedis.hgetAll(key);
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        return jedis.hgetAll(key);
    }

    @Override
    public Set<byte[]> hkeys(byte[] key) {
        return jedis.hkeys(key);
    }

    @Override
    public Set<String> hkeys(String key) {
        return jedis.hkeys(key);
    }

    @Override
    public long incr(byte[] key) {
        return jedis.incr(key);
    }

    @Override
    public long incr(String key) {
        return jedis.incr(key);
    }

    @Override
    public long incrBy(String key, long integer) {
        return jedis.incrBy(key, integer);
    }

    @Override
    public long incrBy(byte[] key, long integer) {
        return jedis.incrBy(key, integer);
    }

    @Override
    public long hlen(byte[] key) {
        return jedis.hlen(key);
    }

    @Override
    public long hlen(String key) {
        return jedis.hlen(key);
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        return jedis.hmget(key, fields);
    }

    @Override
    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        return jedis.hmget(key, fields);
    }

    @Override
    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
        return jedis.hmset(key, hash);
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        return jedis.hmset(key, hash);
    }

    @Override
    public long hset(byte[] key, byte[] field, byte[] value) {
        return jedis.hset(key, field, value);
    }

    @Override
    public long hset(String key, String field, String value) {
        return jedis.hset(key, field, value);
    }

    @Override
    public long hsetnx(byte[] key, byte[] field, byte[] value) {
        return jedis.hsetnx(key, field, value);
    }

    @Override
    public long hsetnx(String key, String field, String value) {
        return jedis.hsetnx(key, field, value);
    }

    @Override
    public long setnx(String key, String value) {
        return jedis.setnx(key, value);
    }

    @Override
    public long setnx(byte[] key, byte[] value) {
        return jedis.setnx(key, value);
    }

    @Override
    public long llen(byte[] key) {
        return jedis.llen(key);
    }

    @Override
    public long llen(String key) {
        return jedis.llen(key);
    }

    @Override
    public byte[] lpop(byte[] key) {
        return jedis.lpop(key);
    }

    @Override
    public String lpop(String key) {
        return jedis.lpop(key);
    }

    @Override
    public long lpush(byte[] key, byte[]... args) {
        return jedis.lpush(key, args);
    }

    @Override
    public long lpush(String key, String... args) {
        return jedis.lpush(key, args);
    }

    @Override
    public long lpushx(byte[] key, byte[]... arg) {
        return jedis.lpushx(key, arg);
    }

    @Override
    public long lpushx(String key, String... arg) {
        return jedis.lpushx(key, arg);
    }

    @Override
    public List<byte[]> lrange(byte[] key, long start, long end) {
        return jedis.lrange(key, start, end);
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        return jedis.lrange(key, start, end);
    }

    @Override
    public long lrem(byte[] key, long count, byte[] value) {
        return jedis.lrem(key, count, value);
    }

    @Override
    public long lrem(String key, long count, String value) {
        return jedis.lrem(key, count, value);
    }

    @Override
    public String lset(byte[] key, long index, byte[] value) {
        return jedis.lset(key, index, value);
    }

    @Override
    public String lset(String key, long index, String value) {
        return jedis.lset(key, index, value);
    }

    @Override
    public String ltrim(byte[] key, long start, long end) {
        return jedis.ltrim(key, start, end);
    }

    @Override
    public String ltrim(String key, long start, long end) {
        return jedis.ltrim(key, start, end);
    }

    @Override
    public long persist(byte[] key) {
        return jedis.persist(key);
    }

    @Override
    public long persist(String key) {
        return jedis.persist(key);
    }

    @Override
    public long pexpire(byte[] key, long milliseconds) {
        return jedis.pexpire(key, milliseconds);
    }

    @Override
    public long pexpire(String key, long milliseconds) {
        return jedis.pexpire(key, milliseconds);
    }

    @Override
    public long pexpireAt(byte[] key, long millisecondsTimestamp) {
        return jedis.pexpireAt(key, millisecondsTimestamp);
    }

    @Override
    public long pexpireAt(String key, long millisecondsTimestamp) {
        return jedis.pexpireAt(key, millisecondsTimestamp);
    }

    @Override
    public long pfadd(byte[] key, byte[]... elements) {
        return jedis.pfadd(key, elements);
    }

    @Override
    public long pfadd(String key, String... elements) {
        return jedis.pfadd(key, elements);
    }

    @Override
    public byte[] rpop(byte[] key) {
        return jedis.rpop(key);
    }

    @Override
    public String rpop(String key) {
        return jedis.rpop(key);
    }

    @Override
    public long rpush(byte[] key, byte[]... args) {
        return jedis.rpush(key, args);
    }

    @Override
    public long rpush(String key, String... string) {
        return jedis.rpush(key, string);
    }

    @Override
    public long rpushx(byte[] key, byte[]... arg) {
        return jedis.rpushx(key, arg);
    }

    @Override
    public long rpushx(String key, String... string) {
        return jedis.rpushx(key, string);
    }

    @Override
    public long sadd(byte[] key, byte[]... member) {
        return jedis.sadd(key, member);
    }

    @Override
    public long sadd(String key, String... member) {
        return jedis.sadd(key, member);
    }

    @Override
    public long scard(byte[] key) {
        return jedis.scard(key);
    }

    @Override
    public long scard(String key) {
        return jedis.scard(key);
    }

    @Override
    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time) {
        return jedis.set(key, value, nxxx, expx, time);
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        return jedis.set(key, value, nxxx, expx, time);
    }

    @Override
    public Boolean setbit(byte[] key, long offset, boolean value) {
        return jedis.setbit(key, offset, value);
    }

    @Override
    public Boolean setbit(byte[] key, long offset, byte[] value) {
        return jedis.setbit(key, offset, value);
    }

    @Override
    public Boolean setbit(String key, long offset, boolean value) {
        return jedis.setbit(key, offset, value);
    }

    @Override
    public Boolean setbit(String key, long offset, String value) {
        return jedis.setbit(key, offset, value);
    }

    @Override
    public String setex(byte[] key, int seconds, byte[] value) {
        return jedis.setex(key, seconds, value);
    }

    @Override
    public String setex(String key, int seconds, String value) {
        return jedis.setex(key, seconds, value);
    }

    @Override
    public long setrange(byte[] key, long offset, byte[] value) {
        return jedis.setrange(key, offset, value);
    }

    @Override
    public long setrange(String key, long offset, String value) {
        return jedis.setrange(key, offset, value);
    }

    @Override
    public Set<byte[]> spop(byte[] key, long count) {
        return jedis.spop(key, count);
    }

    @Override
    public byte[] spop(byte[] key) {
        return jedis.spop(key);
    }

    @Override
    public Set<String> spop(String key, long count) {
        return jedis.spop(key, count);
    }

    @Override
    public String spop(String key) {
        return jedis.spop(key);
    }

    @Override
    public long ttl(byte[] key) {
        return jedis.ttl(key);
    }

    @Override
    public long ttl(String key) {
        return jedis.ttl(key);
    }

    @Override
    public String type(byte[] key) {
        return jedis.type(key);
    }

    @Override
    public String type(String key) {
        return jedis.type(key);
    }

    @Override
    public long zadd(byte[] key, double score, byte[] member) {
        return jedis.zadd(key, score, member);
    }

    @Override
    public long zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        return jedis.zadd(key, scoreMembers);
    }

    @Override
    public long zadd(String key, double score, String member) {
        return jedis.zadd(key, score, member);
    }

    @Override
    public long zadd(String key, Map<String, Double> scoreMembers) {
        return jedis.zadd(key, scoreMembers);
    }

    @Override
    public long zcard(byte[] key) {
        return jedis.zcard(key);
    }

    @Override
    public long zcard(String key) {
        return jedis.zcard(key);
    }

    @Override
    public Set<byte[]> zrange(byte[] key, long start, long end) {
        return jedis.zrange(key, start, end);
    }

    @Override
    public Set<String> zrange(String key, long start, long end) {
        return jedis.zrange(key, start, end);
    }

    @Override
    public boolean sismember(String key, String member) {
        return jedis.sismember(key, member);
    }

    @Override
    public boolean sismember(byte[] key, byte[] member) {
        return jedis.sismember(key, member);
    }

    @Override
    public byte[] lindex(byte[] key, long index) {
        return jedis.lindex(key, index);
    }

    @Override
    public String lindex(String key, long index) {
        return jedis.lindex(key, index);
    }

    @Override
    public String getSet(String key, String value) {
        return jedis.getSet(key, value);
    }

    @Override
    public byte[] getSet(byte[] key, byte[] value) {
        return jedis.getSet(key, value);
    }

    @Override
    public abstract Object initPool(String clusterNode);//由子类实现

    @Override
    public abstract Object initPool(String clusterNode, String password);

    @Override
    public Set<String> smembers(String key) {
        return jedis.smembers(key);
    }

    @Override
    public Set<byte[]> smembers(byte[] key) {
        return jedis.smembers(key);
    }
}
