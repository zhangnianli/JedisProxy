package bonree.impl;

import bonree.IJedis;
import bonree.pipeline.IJedisPipeline;
import bonree.pipeline.Jedis30Pipeline;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 *
 * @date 2016-6-2 下午04:08:26
 * @Author: <a href=mailto:zhangnl@bonree.com>张念礼</a>
 * @Title: Jedis30Impl.java
 * @Package bonree
 * Description:
 * Version: 1.0
 ******************************************************************************/
public abstract class Jedis30Impl implements IJedis {

    private JedisCluster jedisPool;

    public void getResource(Object poolObj) {
        jedisPool = (JedisCluster) poolObj;
    }

    @Override
    public IJedisPipeline pipeline() {
        return new Jedis30Pipeline(jedisPool);
    }

    public void returnResource() {
    }

    @Override
    public String set(String key, String value) {
        return jedisPool.set(key, value);
    }

    @Override
    public long append(String key, String value) {
        return jedisPool.append(key, value);
    }

    @Override
    public long append(byte[] keyByte, byte[] valueByte) {
        return jedisPool.append(keyByte, valueByte);
    }

    @Override
    public String set(byte[] key, byte[] value) {
        return jedisPool.set(key, value);
    }

    @Override
    public long bitcount(String key, long start, long end) {
        return jedisPool.bitcount(key, start, end);
    }

    @Override
    public long bitcount(byte[] key, long start, long end) {
        return jedisPool.bitcount(key, start, end);
    }

    @Override
    public long bitcount(byte[] key) {
        return jedisPool.bitcount(key);
    }

    @Override
    public long bitcount(String key) {
        return jedisPool.bitcount(key);
    }

    @Override
    public void close() throws IOException {
        jedisPool.close();
    }

    @Override
    public long decr(byte[] key) {
        return jedisPool.decr(key);
    }

    @Override
    public long decr(String key) {
        return jedisPool.decr(key);
    }

    @Override
    public long decrBy(byte[] key, long integer) {
        return jedisPool.decrBy(key, integer);
    }

    @Override
    public long decrBy(String key, long integer) {
        return jedisPool.decrBy(key, integer);
    }

    @Override
    public long del(byte[] key) {
        return jedisPool.del(key);
    }

    @Override
    public long del(String key) {
        return jedisPool.del(key);
    }

    @Override
    public boolean exists(String key) {
        return jedisPool.exists(key);
    }

    @Override
    public boolean exists(byte[] key) {
        return jedisPool.exists(key);
    }

    @Override
    public String echo(String arg) {
        return jedisPool.echo(arg);
    }

    @Override
    public byte[] echo(byte[] arg) {
        return jedisPool.echo(arg);
    }

    @Override
    public long expire(byte[] key, int seconds) {
        return jedisPool.expire(key, seconds);
    }

    @Override
    public long expire(String key, int seconds) {
        return jedisPool.expire(key, seconds);
    }

    @Override
    public long expireAt(byte[] key, long unixTime) {
        return jedisPool.expireAt(key, unixTime);
    }

    @Override
    public long expireAt(String key, long unixTime) {
        return jedisPool.expireAt(key, unixTime);
    }

    @Override
    public byte[] get(byte[] key) {
        return jedisPool.get(key);
    }

    @Override
    public String get(String key) {
        return jedisPool.get(key);
    }

    @Override
    public long hdel(byte[] key, byte[]... field) {
        return jedisPool.hdel(key, field);
    }

    @Override
    public long hdel(String key, String... field) {
        return jedisPool.hdel(key, field);
    }

    @Override
    public boolean hexists(byte[] key, byte[] field) {
        return jedisPool.hexists(key, field);
    }

    @Override
    public boolean hexists(String key, String field) {
        return jedisPool.hexists(key, field);
    }

    @Override
    public byte[] hget(byte[] key, byte[] field) {
        return jedisPool.hget(key, field);
    }

    @Override
    public String hget(String key, String field) {
        return jedisPool.hget(key, field);
    }

    @Override
    public Map<byte[], byte[]> hgetAll(byte[] key) {
        return jedisPool.hgetAll(key);
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        return jedisPool.hgetAll(key);
    }

    @Override
    public Set<byte[]> hkeys(byte[] key) {
        return jedisPool.hkeys(key);
    }

    @Override
    public Set<String> hkeys(String key) {
        return jedisPool.hkeys(key);
    }

    @Override
    public long incr(byte[] key) {
        return jedisPool.incr(key);
    }

    @Override
    public long incr(String key) {
        return jedisPool.incr(key);
    }

    @Override
    public long incrBy(String key, long integer) {
        return jedisPool.incrBy(key, integer);
    }

    @Override
    public long incrBy(byte[] key, long integer) {
        return jedisPool.incrBy(key, integer);
    }

    @Override
    public long hlen(byte[] key) {
        return jedisPool.hlen(key);
    }

    @Override
    public long hlen(String key) {
        return jedisPool.hlen(key);
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        return jedisPool.hmget(key, fields);
    }

    @Override
    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        return jedisPool.hmget(key, fields);
    }

    @Override
    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
        return jedisPool.hmset(key, hash);
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        return jedisPool.hmset(key, hash);
    }

    @Override
    public long hset(byte[] key, byte[] field, byte[] value) {
        return jedisPool.hset(key, field, value);
    }

    @Override
    public long hset(String key, String field, String value) {
        return jedisPool.hset(key, field, value);
    }

    @Override
    public long hsetnx(byte[] key, byte[] field, byte[] value) {
        return jedisPool.hsetnx(key, field, value);
    }

    @Override
    public long hsetnx(String key, String field, String value) {
        return jedisPool.hsetnx(key, field, value);
    }

    @Override
    public long setnx(String key, String value) {
        return jedisPool.setnx(key, value);
    }

    @Override
    public long setnx(byte[] key, byte[] value) {
        return jedisPool.setnx(key, value);
    }

    @Override
    public long llen(byte[] key) {
        return jedisPool.llen(key);
    }

    @Override
    public long llen(String key) {
        return jedisPool.llen(key);
    }

    @Override
    public byte[] lpop(byte[] key) {
        return jedisPool.lpop(key);
    }

    @Override
    public String lpop(String key) {
        return jedisPool.lpop(key);
    }

    @Override
    public long lpush(byte[] key, byte[]... args) {
        return jedisPool.lpush(key, args);
    }

    @Override
    public long lpush(String key, String... args) {
        return jedisPool.lpush(key, args);
    }

    @Override
    public long lpushx(byte[] key, byte[]... arg) {
        return jedisPool.lpushx(key, arg);
    }

    @Override
    public long lpushx(String key, String... arg) {
        return jedisPool.lpushx(key, arg);
    }

    @Override
    public List<byte[]> lrange(byte[] key, long start, long end) {
        return jedisPool.lrange(key, start, end);
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        return jedisPool.lrange(key, start, end);
    }

    @Override
    public long lrem(byte[] key, long count, byte[] value) {
        return jedisPool.lrem(key, count, value);
    }

    @Override
    public long lrem(String key, long count, String value) {
        return jedisPool.lrem(key, count, value);
    }

    @Override
    public String lset(byte[] key, long index, byte[] value) {
        return jedisPool.lset(key, index, value);
    }

    @Override
    public String lset(String key, long index, String value) {
        return jedisPool.lset(key, index, value);
    }

    @Override
    public String ltrim(byte[] key, long start, long end) {
        return jedisPool.ltrim(key, start, end);
    }

    @Override
    public String ltrim(String key, long start, long end) {
        return jedisPool.ltrim(key, start, end);
    }

    @Override
    public long persist(byte[] key) {
        return jedisPool.persist(key);
    }

    @Override
    public long persist(String key) {
        return jedisPool.persist(key);
    }

    @Override
    public long pexpire(byte[] key, long milliseconds) {
        return jedisPool.pexpire(key, milliseconds);
    }

    @Override
    public long pexpire(String key, long milliseconds) {
        return jedisPool.pexpire(key, milliseconds);
    }

    @Override
    public long pexpireAt(byte[] key, long millisecondsTimestamp) {
        return jedisPool.pexpireAt(key, millisecondsTimestamp);
    }

    @Override
    public long pexpireAt(String key, long millisecondsTimestamp) {
        return jedisPool.pexpireAt(key, millisecondsTimestamp);
    }

    @Override
    public long pfadd(byte[] key, byte[]... elements) {
        return jedisPool.pfadd(key, elements);
    }

    @Override
    public long pfadd(String key, String... elements) {
        return jedisPool.pfadd(key, elements);
    }

    @Override
    public byte[] rpop(byte[] key) {
        return jedisPool.rpop(key);
    }

    @Override
    public String rpop(String key) {
        return jedisPool.rpop(key);
    }

    @Override
    public long rpush(byte[] key, byte[]... args) {
        return jedisPool.rpush(key, args);
    }

    @Override
    public long rpush(String key, String... string) {
        return jedisPool.rpush(key, string);
    }

    @Override
    public long rpushx(byte[] key, byte[]... arg) {
        return jedisPool.rpushx(key, arg);
    }

    @Override
    public long rpushx(String key, String... string) {
        return jedisPool.rpushx(key, string);
    }

    @Override
    public long sadd(byte[] key, byte[]... member) {
        return jedisPool.sadd(key, member);
    }

    @Override
    public long sadd(String key, String... member) {
        return jedisPool.sadd(key, member);
    }

    @Override
    public long scard(byte[] key) {
        return jedisPool.scard(key);
    }

    @Override
    public long scard(String key) {
        return jedisPool.scard(key);
    }

    @Override
    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time) {
        return jedisPool.set(key, value, nxxx, expx, time);
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        return jedisPool.set(key, value, nxxx, expx, time);
    }

    @Override
    public Boolean setbit(byte[] key, long offset, boolean value) {
        return jedisPool.setbit(key, offset, value);
    }

    @Override
    public Boolean setbit(byte[] key, long offset, byte[] value) {
        return jedisPool.setbit(key, offset, value);
    }

    @Override
    public Boolean setbit(String key, long offset, boolean value) {
        return jedisPool.setbit(key, offset, value);
    }

    @Override
    public Boolean setbit(String key, long offset, String value) {
        return jedisPool.setbit(key, offset, value);
    }

    @Override
    public String setex(byte[] key, int seconds, byte[] value) {
        return jedisPool.setex(key, seconds, value);
    }

    @Override
    public String setex(String key, int seconds, String value) {
        return jedisPool.setex(key, seconds, value);
    }

    @Override
    public long setrange(byte[] key, long offset, byte[] value) {
        return jedisPool.setrange(key, offset, value);
    }

    @Override
    public long setrange(String key, long offset, String value) {
        return jedisPool.setrange(key, offset, value);
    }

    @Override
    public Set<byte[]> spop(byte[] key, long count) {
        return jedisPool.spop(key, count);
    }

    @Override
    public byte[] spop(byte[] key) {
        return jedisPool.spop(key);
    }

    @Override
    public Set<String> spop(String key, long count) {
        return jedisPool.spop(key, count);
    }

    @Override
    public String spop(String key) {
        return jedisPool.spop(key);
    }

    @Override
    public long ttl(byte[] key) {
        return jedisPool.ttl(key);
    }

    @Override
    public long ttl(String key) {
        return jedisPool.ttl(key);
    }

    @Override
    public String type(byte[] key) {
        return jedisPool.type(key);
    }

    @Override
    public String type(String key) {
        return jedisPool.type(key);
    }

    @Override
    public long zadd(byte[] key, double score, byte[] member) {
        return jedisPool.zadd(key, score, member);
    }

    @Override
    public long zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        return jedisPool.zadd(key, scoreMembers);
    }

    @Override
    public long zadd(String key, double score, String member) {
        return jedisPool.zadd(key, score, member);
    }

    @Override
    public long zadd(String key, Map<String, Double> scoreMembers) {
        return jedisPool.zadd(key, scoreMembers);
    }

    @Override
    public long zcard(byte[] key) {
        return jedisPool.zcard(key);
    }

    @Override
    public long zcard(String key) {
        return jedisPool.zcard(key);
    }

    @Override
    public Set<byte[]> zrange(byte[] key, long start, long end) {
        return jedisPool.zrange(key, start, end);
    }

    @Override
    public Set<String> zrange(String key, long start, long end) {
        return jedisPool.zrange(key, start, end);
    }


    @Override
    public boolean sismember(String key, String member) {
        return jedisPool.sismember(key, member);
    }

    @Override
    public boolean sismember(byte[] key, byte[] member) {
        return jedisPool.sismember(key, member);
    }

    @Override
    public byte[] lindex(byte[] key, long index) {
        return jedisPool.lindex(key, index);
    }

    @Override
    public String lindex(String key, long index) {
        return jedisPool.lindex(key, index);
    }

    @Override
    public String getSet(String key, String value) {
        return jedisPool.getSet(key, value);
    }

    @Override
    public byte[] getSet(byte[] key, byte[] value) {
        return jedisPool.getSet(key, value);
    }


    @Override
    public abstract Object initPool(String clusterNode);

    @Override
    public abstract Object initPool(String clusterNode, String password);

    @Override
    public Set<String> smembers(String key) {
        return jedisPool.smembers(key);
    }

    @Override
    public Set<byte[]> smembers(byte[] key) {
        return jedisPool.smembers(key);
    }
}
