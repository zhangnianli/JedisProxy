package bonree.pipeline;

import redis.clients.jedis.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by impala on 2017/9/1.
 */
public interface IJedisPipeline {

    public Response<String> set(String key, String value);

    public Response<String> set(byte[] key, byte[] value);

    public Response<Long> append(String key, String value);

    public Response<Long> append(byte[] keyByte, byte[] valueByte);

    public Response<Long> bitcount(String key, long start, long end);

    public Response<Long> bitcount(byte[] key, long start, long end);

    public Response<Long> bitcount(String key);

    public Response<Long> bitcount(byte[] key);

    public void close() throws IOException;

    public Response<Long> incr(byte[] key);

    public Response<Long> incr(String key);

    public Response<Long> incrBy(String key, long integer);

    public Response<Long> incrBy(byte[] key, long integer);

    public Response<Long> decr(byte[] key);

    public Response<Long> decr(String key);

    public Response<Long> decrBy(byte[] key, long integer);

    public Response<Long> decrBy(String key, long integer);

    public Response<Long> del(byte[] key);

    public Response<Long> del(String key);

    public Response<Boolean> exists(byte[] key);

    public Response<Boolean> exists(String key);

    public Response<String> echo(String arg);

    public Response<byte[]> echo(byte[] arg);

    public Response<Long> expire(byte[] key, int seconds);

    public Response<Long> expire(String key, int seconds);

    public Response<Long> expireAt(byte[] key, long unixTime);

    public Response<Long> expireAt(String key, long unixTime);

    public Response<byte[]> get(byte[] key);

    public Response<String> get(String key);

    public Response<Long> hdel(byte[] key, byte[]... field);

    public Response<Long> hdel(String key, String... field);

    public Response<Boolean> hexists(byte[] key, byte[] field);

    public Response<Boolean> hexists(String key, String field);

    public Response<byte[]> hget(byte[] key, byte[] field);

    public Response<String> hget(String key, String field);

    public Response<Map<byte[], byte[]>> hgetAll(byte[] key);

    public Response<Map<String, String>> hgetAll(String key);

    public Response<Set<byte[]>> hkeys(byte[] key);

    public Response<Set<String>> hkeys(String key);

    public Response<Long> hlen(byte[] key);

    public Response<Long> hlen(String key);

    public Response<List<String>> hmget(String key, String... fields);

    public Response<List<byte[]>> hmget(byte[] key, byte[]... fields);

    public Response<String> hmset(byte[] key, Map<byte[], byte[]> hash);

    public Response<String> hmset(String key, Map<String, String> hash);

    public Response<Long> hset(byte[] key, byte[] field, byte[] value);

    public Response<Long> hset(String key, String field, String value);

    public Response<Long> hsetnx(byte[] key, byte[] field, byte[] value);

    public Response<Long> hsetnx(String key, String field, String value);

    public Response<Long> setnx(String key, String value);

    public Response<Long> setnx(byte[] key, byte[] value);

    public Response<Long> llen(byte[] key);

    public Response<Long> llen(String key);

    public Response<byte[]> lpop(byte[] key);

    public Response<String> lpop(String key);

    public Response<Long> lpush(byte[] key, byte[]... args);

    public Response<Long> lpush(String key, String... args);

    public Response<Long> lpushx(byte[] key, byte[]... arg);

    public Response<Long> lpushx(String key, String... arg);

    public Response<List<byte[]>> lrange(byte[] key, long start, long end);

    public Response<List<String>> lrange(String key, long start, long end);

    public Response<Long> lrem(byte[] key, long count, byte[] value);

    public Response<Long> lrem(String key, long count, String value);

    public Response<String> lset(byte[] key, long index, byte[] value);

    public Response<String> lset(String key, long index, String value);

    public Response<String> ltrim(byte[] key, long start, long end);

    public Response<String> ltrim(String key, long start, long end);

    public Response<Long> persist(byte[] key);

    public Response<Long> persist(String key);

    public Response<Long> pexpire(byte[] key, long milliseconds);

    public Response<Long> pexpire(String key, long milliseconds);

    public Response<Long> pexpireAt(byte[] key, long millisecondsTimestamp);

    public Response<Long> pexpireAt(String key, long millisecondsTimestamp);

    public Response<Long> pfadd(byte[] key, byte[]... elements);

    public Response<Long> pfadd(String key, String... elements);

    public Response<byte[]> rpop(byte[] key);

    public Response<String> rpop(String key);

    public Response<Long> rpush(byte[] key, byte[]... args);

    public Response<Long> rpush(String key, String... string);

    public Response<Long> rpushx(byte[] key, byte[]... arg);

    public Response<Long> rpushx(String key, String... string);

    public Response<Long> sadd(byte[] key, byte[]... member);

    public Response<Long> sadd(String key, String... member);

    public Response<Long> scard(byte[] key);

    public Response<Long> scard(String key);

    public Response<String> set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, int time);

    public Response<String> set(String key, String value, String nxxx, String expx, int time);

    public Response<Boolean> setbit(byte[] key, long offset, byte[] value);

    public Response<Boolean> setbit(String key, long offset, boolean value);

    public Response<String> setex(byte[] key, int seconds, byte[] value);

    public Response<String> setex(String key, int seconds, String value);

    public Response<Long> setrange(byte[] key, long offset, byte[] value);

    public Response<Long> setrange(String key, long offset, String value);

    public Response<Set<byte[]>> spop(byte[] key, long count);

    public Response<byte[]> spop(byte[] key);

    public Response<Set<String>> spop(String key, long count);

    public Response<String> spop(String key);

    public Response<Long> ttl(byte[] key);

    public Response<Long> ttl(String key);

    public Response<String> type(byte[] key);

    public Response<String> type(String key);

    public Response<Long> zadd(byte[] key, double score, byte[] member);

    public Response<Long> zadd(byte[] key, Map<byte[], Double> scoreMembers);

    public Response<Long> zadd(String key, double score, String member);

    public Response<Long> zadd(String key, Map<String, Double> scoreMembers);

    public Response<Long> zcard(byte[] key);

    public Response<Long> zcard(String key);

    public Response<Set<byte[]>> zrange(byte[] key, long start, long end);

    public Response<Set<String>> zrange(String key, long start, long end);

    public Response<Boolean> sismember(String key, String member);

    public Response<Boolean> sismember(byte[] key, byte[] member);

    public Response<byte[]> lindex(byte[] key, long index);

    public Response<String> lindex(String key, long index);

    public Response<String> getSet(String key, String newValue);

    public Response<byte[]> getSet(byte[] key, byte[] newValue);

    public void sync();

    public Response<Set<String>> smembers(String key);

    public Response<Set<byte[]>> smembers(byte[] key);

}
