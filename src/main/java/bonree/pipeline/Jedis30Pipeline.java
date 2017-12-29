package bonree.pipeline;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by impala on 2017/9/1.
 */
public class Jedis30Pipeline implements IJedisPipeline {
    private JedisClusterPipeline jedisClusterPipeline;

    public Jedis30Pipeline(JedisCluster jedisCluster) {
        jedisClusterPipeline = new JedisClusterPipeline(jedisCluster);
    }

    @Override
    public Response<String> set(String key, String value) {
        return this.jedisClusterPipeline.set(key, value);
    }

    @Override
    public Response<String> set(byte[] key, byte[] value) {
        return this.jedisClusterPipeline.set(key, value);
    }

    @Override
    public Response<Long> append(String key, String value) {
        return this.jedisClusterPipeline.append(key, value);
    }

    @Override
    public Response<Long> append(byte[] keyByte, byte[] valueByte) {
        return this.jedisClusterPipeline.append(keyByte, valueByte);
    }

    @Override
    public Response<Long> bitcount(String key, long start, long end) {
        return this.jedisClusterPipeline.bitcount(key, start, end);
    }

    @Override
    public Response<Long> bitcount(byte[] key, long start, long end) {
        return this.jedisClusterPipeline.bitcount(key, start, end);
    }

    @Override
    public Response<Long> bitcount(String key) {
        return this.jedisClusterPipeline.bitcount(key);
    }

    @Override
    public Response<Long> bitcount(byte[] key) {
        return this.jedisClusterPipeline.bitcount(key);
    }

    @Override
    public void close() throws IOException {
        this.jedisClusterPipeline.close();
    }

    @Override
    public Response<Long> incr(byte[] key) {
        return this.jedisClusterPipeline.incr(key);
    }

    @Override
    public Response<Long> incr(String key) {
        return this.jedisClusterPipeline.incr(key);
    }

    @Override
    public Response<Long> incrBy(String key, long integer) {
        return this.jedisClusterPipeline.incrBy(key, integer);
    }

    @Override
    public Response<Long> incrBy(byte[] key, long integer) {
        return this.jedisClusterPipeline.incrBy(key, integer);
    }

    @Override
    public Response<Long> decr(byte[] key) {
        return this.jedisClusterPipeline.decr(key);
    }

    @Override
    public Response<Long> decr(String key) {
        return this.jedisClusterPipeline.decr(key);
    }

    @Override
    public Response<Long> decrBy(byte[] key, long integer) {
        return this.jedisClusterPipeline.decrBy(key, integer);
    }

    @Override
    public Response<Long> decrBy(String key, long integer) {
        return this.jedisClusterPipeline.decrBy(key, integer);
    }

    @Override
    public Response<Long> del(byte[] key) {
        return this.jedisClusterPipeline.del(key);
    }

    @Override
    public Response<Long> del(String key) {
        return this.jedisClusterPipeline.del(key);
    }

    @Override
    public Response<Boolean> exists(byte[] key) {
        return this.jedisClusterPipeline.exists(key);
    }

    @Override
    public Response<Boolean> exists(String key) {
        return this.jedisClusterPipeline.exists(key);
    }

    @Override
    public Response<String> echo(String arg) {
        return this.jedisClusterPipeline.echo(arg);
    }

    @Override
    public Response<byte[]> echo(byte[] arg) {
        return this.jedisClusterPipeline.echo(arg);
    }

    @Override
    public Response<Long> expire(byte[] key, int seconds) {
        return this.jedisClusterPipeline.expire(key, seconds);
    }

    @Override
    public Response<Long> expire(String key, int seconds) {
        return this.jedisClusterPipeline.expire(key, seconds);
    }

    @Override
    public Response<Long> expireAt(byte[] key, long unixTime) {
        return this.jedisClusterPipeline.expireAt(key, unixTime);
    }

    @Override
    public Response<Long> expireAt(String key, long unixTime) {
        return this.jedisClusterPipeline.expireAt(key, unixTime);
    }

    @Override
    public Response<byte[]> get(byte[] key) {
        return this.jedisClusterPipeline.get(key);
    }

    @Override
    public Response<String> get(String key) {
        return this.jedisClusterPipeline.get(key);
    }

    @Override
    public Response<Long> hdel(byte[] key, byte[]... field) {
        return this.jedisClusterPipeline.hdel(key, field);
    }

    @Override
    public Response<Long> hdel(String key, String... field) {
        return this.jedisClusterPipeline.hdel(key, field);
    }

    @Override
    public Response<Boolean> hexists(byte[] key, byte[] field) {
        return this.jedisClusterPipeline.hexists(key, field);
    }

    @Override
    public Response<Boolean> hexists(String key, String field) {
        return this.jedisClusterPipeline.hexists(key, field);
    }

    @Override
    public Response<byte[]> hget(byte[] key, byte[] field) {
        return this.jedisClusterPipeline.hget(key, field);
    }

    @Override
    public Response<String> hget(String key, String field) {
        return this.jedisClusterPipeline.hget(key, field);
    }

    @Override
    public Response<Map<byte[], byte[]>> hgetAll(byte[] key) {
        return this.jedisClusterPipeline.hgetAll(key);
    }

    @Override
    public Response<Map<String, String>> hgetAll(String key) {
        return this.jedisClusterPipeline.hgetAll(key);
    }

    @Override
    public Response<Set<byte[]>> hkeys(byte[] key) {
        return this.jedisClusterPipeline.hkeys(key);
    }

    @Override
    public Response<Set<String>> hkeys(String key) {
        return this.jedisClusterPipeline.hkeys(key);
    }

    @Override
    public Response<Long> hlen(byte[] key) {
        return this.jedisClusterPipeline.hlen(key);
    }

    @Override
    public Response<Long> hlen(String key) {
        return this.jedisClusterPipeline.hlen(key);
    }

    @Override
    public Response<List<String>> hmget(String key, String... fields) {
        return this.jedisClusterPipeline.hmget(key, fields);
    }

    @Override
    public Response<List<byte[]>> hmget(byte[] key, byte[]... fields) {
        return this.jedisClusterPipeline.hmget(key, fields);
    }

    @Override
    public Response<String> hmset(byte[] key, Map<byte[], byte[]> hash) {
        return this.jedisClusterPipeline.hmset(key, hash);
    }

    @Override
    public Response<String> hmset(String key, Map<String, String> hash) {
        return this.jedisClusterPipeline.hmset(key, hash);
    }

    @Override
    public Response<Long> hset(byte[] key, byte[] field, byte[] value) {
        return this.jedisClusterPipeline.hset(key, field, value);
    }

    @Override
    public Response<Long> hset(String key, String field, String value) {
        return this.jedisClusterPipeline.hset(key, field, value);
    }

    @Override
    public Response<Long> hsetnx(byte[] key, byte[] field, byte[] value) {
        return this.jedisClusterPipeline.hsetnx(key, field, value);
    }

    @Override
    public Response<Long> hsetnx(String key, String field, String value) {
        return this.jedisClusterPipeline.hsetnx(key, field, value);
    }

    @Override
    public Response<Long> setnx(String key, String value) {
        return this.jedisClusterPipeline.setnx(key, value);
    }

    @Override
    public Response<Long> setnx(byte[] key, byte[] value) {
        return this.jedisClusterPipeline.setnx(key, value);
    }

    @Override
    public Response<Long> llen(byte[] key) {
        return this.jedisClusterPipeline.llen(key);
    }

    @Override
    public Response<Long> llen(String key) {
        return this.jedisClusterPipeline.llen(key);
    }

    @Override
    public Response<byte[]> lpop(byte[] key) {
        return this.jedisClusterPipeline.lpop(key);
    }

    @Override
    public Response<String> lpop(String key) {
        return this.jedisClusterPipeline.lpop(key);
    }

    @Override
    public Response<Long> lpush(byte[] key, byte[]... args) {
        return this.jedisClusterPipeline.lpush(key, args);
    }

    @Override
    public Response<Long> lpush(String key, String... args) {
        return this.jedisClusterPipeline.lpush(key, args);
    }

    @Override
    public Response<Long> lpushx(byte[] key, byte[]... arg) {
        return this.jedisClusterPipeline.lpushx(key, arg);
    }

    @Override
    public Response<Long> lpushx(String key, String... arg) {
        return this.jedisClusterPipeline.lpushx(key, arg);
    }

    @Override
    public Response<List<byte[]>> lrange(byte[] key, long start, long end) {
        return this.jedisClusterPipeline.lrange(key, start, end);
    }

    @Override
    public Response<List<String>> lrange(String key, long start, long end) {
        return this.jedisClusterPipeline.lrange(key, start, end);
    }

    @Override
    public Response<Long> lrem(byte[] key, long count, byte[] value) {
        return this.jedisClusterPipeline.lrem(key, count, value);
    }

    @Override
    public Response<Long> lrem(String key, long count, String value) {
        return this.jedisClusterPipeline.lrem(key, count, value);
    }

    @Override
    public Response<String> lset(byte[] key, long index, byte[] value) {
        return this.jedisClusterPipeline.lset(key, index, value);
    }

    @Override
    public Response<String> lset(String key, long index, String value) {
        return this.jedisClusterPipeline.lset(key, index, value);
    }

    @Override
    public Response<String> ltrim(byte[] key, long start, long end) {
        return this.jedisClusterPipeline.ltrim(key, start, end);
    }

    @Override
    public Response<String> ltrim(String key, long start, long end) {
        return this.jedisClusterPipeline.ltrim(key, start, end);
    }

    @Override
    public Response<Long> persist(byte[] key) {
        return this.jedisClusterPipeline.persist(key);
    }

    @Override
    public Response<Long> persist(String key) {
        return this.jedisClusterPipeline.persist(key);
    }

    @Override
    public Response<Long> pexpire(byte[] key, long milliseconds) {
        return this.jedisClusterPipeline.pexpire(key, milliseconds);
    }

    @Override
    public Response<Long> pexpire(String key, long milliseconds) {
        return this.jedisClusterPipeline.pexpire(key, milliseconds);
    }

    @Override
    public Response<Long> pexpireAt(byte[] key, long millisecondsTimestamp) {
        return this.jedisClusterPipeline.pexpireAt(key, millisecondsTimestamp);
    }

    @Override
    public Response<Long> pexpireAt(String key, long millisecondsTimestamp) {
        return this.jedisClusterPipeline.expireAt(key, millisecondsTimestamp);
    }

    @Override
    public Response<Long> pfadd(byte[] key, byte[]... elements) {
        return this.jedisClusterPipeline.pfadd(key, elements);
    }

    @Override
    public Response<Long> pfadd(String key, String... elements) {
        return this.jedisClusterPipeline.pfadd(key, elements);
    }

    @Override
    public Response<byte[]> rpop(byte[] key) {
        return this.jedisClusterPipeline.rpop(key);
    }

    @Override
    public Response<String> rpop(String key) {
        return this.jedisClusterPipeline.rpop(key);
    }

    @Override
    public Response<Long> rpush(byte[] key, byte[]... args) {
        return this.jedisClusterPipeline.rpush(key, args);
    }

    @Override
    public Response<Long> rpush(String key, String... string) {
        return this.jedisClusterPipeline.rpush(key, string);
    }

    @Override
    public Response<Long> rpushx(byte[] key, byte[]... arg) {
        return this.jedisClusterPipeline.rpushx(key, arg);
    }

    @Override
    public Response<Long> rpushx(String key, String... string) {
        return this.jedisClusterPipeline.rpushx(key, string);
    }

    @Override
    public Response<Long> sadd(byte[] key, byte[]... member) {
        return this.jedisClusterPipeline.sadd(key, member);
    }

    @Override
    public Response<Long> sadd(String key, String... member) {
        return this.jedisClusterPipeline.sadd(key, member);
    }

    @Override
    public Response<Long> scard(byte[] key) {
        return this.jedisClusterPipeline.scard(key);
    }

    @Override
    public Response<Long> scard(String key) {
        return this.jedisClusterPipeline.scard(key);
    }

    @Override
    public Response<String> set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, int time) {
        return this.jedisClusterPipeline.set(key, value, nxxx, expx, time);
    }

    @Override
    public Response<String> set(String key, String value, String nxxx, String expx, int time) {
        return this.jedisClusterPipeline.set(key, value, nxxx, expx, time);
    }


    @Override
    public Response<Boolean> setbit(byte[] key, long offset, byte[] value) {
        return this.jedisClusterPipeline.setbit(key, offset, value);
    }

    @Override
    public Response<Boolean> setbit(String key, long offset, boolean value) {
        return this.jedisClusterPipeline.setbit(key, offset, value);
    }

    @Override
    public Response<String> setex(byte[] key, int seconds, byte[] value) {
        return this.jedisClusterPipeline.setex(key, seconds, value);
    }

    @Override
    public Response<String> setex(String key, int seconds, String value) {
        return this.jedisClusterPipeline.setex(key, seconds, value);
    }

    @Override
    public Response<Long> setrange(byte[] key, long offset, byte[] value) {
        return this.jedisClusterPipeline.setrange(key, offset, value);
    }

    @Override
    public Response<Long> setrange(String key, long offset, String value) {
        return this.jedisClusterPipeline.setrange(key, offset, value);
    }

    @Override
    public Response<Set<byte[]>> spop(byte[] key, long count) {
        return this.jedisClusterPipeline.spop(key, count);
    }

    @Override
    public Response<byte[]> spop(byte[] key) {
        return this.jedisClusterPipeline.spop(key);
    }

    @Override
    public Response<Set<String>> spop(String key, long count) {
        return this.jedisClusterPipeline.spop(key, count);
    }

    @Override
    public Response<String> spop(String key) {
        return this.jedisClusterPipeline.spop(key);
    }

    @Override
    public Response<Long> ttl(byte[] key) {
        return this.jedisClusterPipeline.ttl(key);
    }

    @Override
    public Response<Long> ttl(String key) {
        return this.jedisClusterPipeline.ttl(key);
    }

    @Override
    public Response<String> type(byte[] key) {
        return this.jedisClusterPipeline.type(key);
    }

    @Override
    public Response<String> type(String key) {
        return this.jedisClusterPipeline.type(key);
    }

    @Override
    public Response<Long> zadd(byte[] key, double score, byte[] member) {
        return this.jedisClusterPipeline.zadd(key, score, member);
    }

    @Override
    public Response<Long> zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        return this.jedisClusterPipeline.zadd(key, scoreMembers);
    }

    @Override
    public Response<Long> zadd(String key, double score, String member) {
        return this.jedisClusterPipeline.zadd(key, score, member);
    }

    @Override
    public Response<Long> zadd(String key, Map<String, Double> scoreMembers) {
        return this.jedisClusterPipeline.zadd(key, scoreMembers);
    }

    @Override
    public Response<Long> zcard(byte[] key) {
        return this.jedisClusterPipeline.zcard(key);
    }

    @Override
    public Response<Long> zcard(String key) {
        return this.jedisClusterPipeline.zcard(key);
    }

    @Override
    public Response<Set<byte[]>> zrange(byte[] key, long start, long end) {
        return this.jedisClusterPipeline.zrange(key, start, end);
    }

    @Override
    public Response<Set<String>> zrange(String key, long start, long end) {
        return this.jedisClusterPipeline.zrange(key, start, end);
    }

    @Override
    public Response<Boolean> sismember(String key, String member) {
        return this.jedisClusterPipeline.sismember(key, member);
    }

    @Override
    public Response<Boolean> sismember(byte[] key, byte[] member) {
        return this.jedisClusterPipeline.sismember(key, member);
    }

    @Override
    public Response<byte[]> lindex(byte[] key, long index) {
        return this.jedisClusterPipeline.lindex(key, index);
    }

    @Override
    public Response<String> lindex(String key, long index) {
        return this.jedisClusterPipeline.lindex(key, index);
    }

    @Override
    public Response<String> getSet(String key, String newValue) {
        return this.jedisClusterPipeline.getSet(key, newValue);
    }

    @Override
    public Response<byte[]> getSet(byte[] key, byte[] newValue) {
        return this.jedisClusterPipeline.getSet(key, newValue);
    }

    @Override
    public void sync() {
        this.jedisClusterPipeline.sync();
    }

    @Override
    public Response<Set<String>> smembers(String key) {
        return this.jedisClusterPipeline.smembers(key);
    }


    @Override
    public Response<Set<byte[]>> smembers(byte[] key) {
        return this.jedisClusterPipeline.smembers(key);
    }
}
