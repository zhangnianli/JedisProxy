package bonree.proxy;

import bonree.pipeline.IJedisPipeline;
import bonree.utils.ProxyUtils;
import redis.clients.jedis.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by impala on 2017/9/1.
 */
public class JedisPipelineProxy {
    private int retryCount = 3;                //重试次数
    private long sleepTime = 10000;                //重试间隔
    private String keyPrefix = "";                //key前缀,默认为""
    private IJedisPipeline jedisPipeline;


    /**
     * @param reCount
     * @param sleep
     * @param prefix
     * @param jedisPipeline
     */
    public JedisPipelineProxy(int reCount, long sleep, String prefix, IJedisPipeline jedisPipeline) {
        instance(reCount, sleep, prefix, jedisPipeline);
    }

    /**
     * @param reCount
     * @param sleep
     * @param prefix
     * @param jedisPipeline
     */
    private void instance(int reCount, long sleep, String prefix, IJedisPipeline jedisPipeline) {
        keyPrefix = prefix;
        sleepTime = sleep;
        retryCount = reCount;
        this.jedisPipeline = jedisPipeline;
    }


    /**
     * 概述：释放资源
     *
     * @Title: close
     * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
     */
    public void close() throws IOException {
        jedisPipeline.close();
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

    public Response<Long> append(byte[] key, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.append(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.append(getKey(key), value);
    }

    public Response<Long> append(String key, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.append(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.append(getKey(key), value);
    }

    public Response<Long> bitcount(byte[] key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.bitcount(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.bitcount(getKey(key), start, end);
    }

    public Response<Long> bitcount(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.bitcount(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.bitcount(getKey(key));
    }

    public Response<Long> bitcount(String key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.bitcount(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }

        }
        return jedisPipeline.bitcount(getKey(key), start, end);
    }

    public Response<Long> bitcount(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.bitcount(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.bitcount(getKey(key));
    }

    public Response<Long> decr(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.decr(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.decr(getKey(key));
    }

    public Response<Long> decr(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.decr(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.decr(getKey(key));
    }

    public Response<Long> decrBy(byte[] key, long integer) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.decrBy(getKey(key), integer);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.decrBy(getKey(key), integer);
    }

    public Response<Long> decrBy(String key, long integer) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.decrBy(getKey(key), integer);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.decrBy(getKey(key), integer);
    }

    public Response<Long> del(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.del(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.del(getKey(key));
    }

    public Response<Long> del(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.del(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.del(getKey(key));
    }

    public Response<byte[]> echo(byte[] arg) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.echo(arg);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.echo(arg);
    }

    public Response<String> echo(String string) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.echo(string);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.echo(string);
    }

    public Response<Boolean> exists(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.exists(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.exists(getKey(key));
    }

    public Response<Boolean> exists(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.exists(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.exists(getKey(key));
    }

    public Response<Long> expire(byte[] key, int seconds) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.expire(getKey(key), seconds);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.expire(getKey(key), seconds);
    }

    public Response<Long> expire(String key, int seconds) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.expire(getKey(key), seconds);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.expire(getKey(key), seconds);
    }

    public Response<Long> expireAt(byte[] key, long unixTime) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.expireAt(getKey(key), unixTime);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.expireAt(getKey(key), unixTime);
    }

    public Response<Long> expireAt(String key, long unixTime) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.expireAt(getKey(key), unixTime);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.expireAt(getKey(key), unixTime);
    }

    public Response<byte[]> get(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.get(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.get(getKey(key));
    }

    public Response<String> get(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.get(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.get(getKey(key));
    }

    public int hashCode() {
        return jedisPipeline.hashCode();
    }

    public Response<Long> hdel(byte[] key, byte[]... field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hdel(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hdel(getKey(key), field);
    }

    public Response<Long> hdel(String key, String... field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hdel(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hdel(getKey(key), field);
    }

    public Response<Boolean> hexists(byte[] key, byte[] field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hexists(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hexists(getKey(key), field);
    }

    public Response<Boolean> hexists(String key, String field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hexists(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hexists(getKey(key), field);
    }

    public Response<byte[]> hget(byte[] key, byte[] field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hget(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hget(getKey(key), field);
    }

    public Response<String> hget(String key, String field) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hget(getKey(key), field);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hget(getKey(key), field);
    }

    public Response<Map<byte[], byte[]>> hgetAll(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hgetAll(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hgetAll(getKey(key));
    }

    public Response<Map<String, String>> hgetAll(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hgetAll(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hgetAll(getKey(key));
    }

    public Response<Set<byte[]>> hkeys(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hkeys(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hkeys(getKey(key));
    }

    public Response<Set<String>> hkeys(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hkeys(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hkeys(getKey(key));
    }

    public Response<Long> hlen(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hlen(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hlen(getKey(key));
    }

    public Response<Long> hlen(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hlen(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hlen(getKey(key));
    }

    public Response<List<byte[]>> hmget(byte[] key, byte[]... fields) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hmget(getKey(key), fields);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hmget(getKey(key), fields);
    }

    public Response<List<String>> hmget(String key, String... fields) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hmget(getKey(key), fields);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hmget(getKey(key), fields);
    }

    public Response<String> hmset(byte[] key, Map<byte[], byte[]> hash) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hmset(getKey(key), hash);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hmset(getKey(key), hash);
    }

    public Response<String> hmset(String key, Map<String, String> hash) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hmset(getKey(key), hash);
            } catch (Exception e) {
                sleep();
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hmset(getKey(key), hash);
    }

    public Response<Long> hset(byte[] key, byte[] field, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hset(getKey(key), field, value);
            } catch (Exception e) {
                sleep();
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hset(getKey(key), field, value);
    }

    public Response<Long> hset(String key, String field, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hset(getKey(key), field, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hset(getKey(key), field, value);
    }

    public Response<Long> hsetnx(byte[] key, byte[] field, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hsetnx(getKey(key), field, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hsetnx(getKey(key), field, value);
    }

    public Response<Long> hsetnx(String key, String field, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.hsetnx(getKey(key), field, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.hsetnx(getKey(key), field, value);
    }

    public Response<Long> incr(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.incr(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.incr(getKey(key));
    }

    public Response<Long> incr(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.incr(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.incr(getKey(key));
    }

    public Response<Long> incrBy(byte[] key, long integer) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.incrBy(getKey(key), integer);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.incrBy(getKey(key), integer);
    }

    public Response<Long> incrBy(String key, long integer) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.incrBy(getKey(key), integer);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.incrBy(getKey(key), integer);
    }

    public Response<Long> llen(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.llen(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.llen(getKey(key));
    }

    public Response<Long> llen(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.llen(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.llen(getKey(key));
    }

    public Response<byte[]> lpop(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lpop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lpop(getKey(key));
    }

    public Response<String> lpop(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lpop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lpop(getKey(key));
    }

    public Response<Long> lpush(byte[] key, byte[]... args) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lpush(getKey(key), args);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lpush(getKey(key), args);
    }

    public Response<Long> lpush(String key, String... string) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lpush(getKey(key), string);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lpush(getKey(key), string);
    }

    public Response<Long> lpushx(byte[] key, byte[]... arg) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lpushx(getKey(key), arg);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lpushx(getKey(key), arg);
    }

    public Response<Long> lpushx(String key, String... string) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lpushx(getKey(key), string);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lpushx(getKey(key), string);
    }

    public Response<List<byte[]>> lrange(byte[] key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lrange(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lrange(getKey(key), start, end);
    }

    public Response<List<String>> lrange(String key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lrange(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lrange(getKey(key), start, end);
    }

    public Response<Long> lrem(byte[] key, long count, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lrem(getKey(key), count, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lrem(getKey(key), count, value);
    }

    public Response<Long> lrem(String key, long count, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lrem(getKey(key), count, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lrem(getKey(key), count, value);
    }

    public Response<String> lset(byte[] key, long index, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lset(getKey(key), index, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lset(getKey(key), index, value);
    }

    public Response<String> lset(String key, long index, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lset(getKey(key), index, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lset(getKey(key), index, value);
    }

    public Response<String> ltrim(byte[] key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.ltrim(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.ltrim(getKey(key), start, end);
    }

    public Response<String> ltrim(String key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.ltrim(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.ltrim(getKey(key), start, end);
    }

    public Response<Long> persist(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.persist(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.persist(getKey(key));
    }

    public Response<Long> persist(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.persist(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.persist(getKey(key));
    }

    public Response<Long> pexpire(byte[] key, long milliseconds) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.pexpire(getKey(key), milliseconds);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.pexpire(getKey(key), milliseconds);
    }

    public Response<Long> pexpire(String key, long milliseconds) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.pexpire(getKey(key), milliseconds);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.pexpire(getKey(key), milliseconds);
    }

    public Response<Long> pexpireAt(byte[] key, long millisecondsTimestamp) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.pexpireAt(getKey(key), millisecondsTimestamp);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.pexpireAt(getKey(key), millisecondsTimestamp);
    }

    public Response<Long> pexpireAt(String key, long millisecondsTimestamp) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.pexpireAt(getKey(key), millisecondsTimestamp);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.pexpireAt(getKey(key), millisecondsTimestamp);
    }

    public Response<Long> pfadd(byte[] key, byte[]... elements) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.pfadd(getKey(key), elements);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.pfadd(getKey(key), elements);
    }

    public Response<Long> pfadd(String key, String... elements) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.pfadd(getKey(key), elements);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.pfadd(getKey(key), elements);
    }


    public Response<byte[]> rpop(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.rpop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.rpop(getKey(key));
    }

    public Response<String> rpop(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.rpop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.rpop(getKey(key));
    }


    public Response<Long> rpush(byte[] key, byte[]... args) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.rpush(getKey(key), args);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.rpush(getKey(key), args);
    }

    public Response<Long> rpush(String key, String... string) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.rpush(getKey(key), string);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.rpush(getKey(key), string);
    }

    public Response<Long> rpushx(byte[] key, byte[]... arg) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.rpushx(getKey(key), arg);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.rpushx(getKey(key), arg);
    }

    public Response<Long> rpushx(String key, String... string) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.rpushx(getKey(key), string);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.rpushx(getKey(key), string);
    }

    public Response<Long> sadd(byte[] key, byte[]... member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.sadd(getKey(key), member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.sadd(getKey(key), member);
    }

    public Response<Long> sadd(String key, String... member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.sadd(getKey(key), member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.sadd(getKey(key), member);
    }

    public Response<Long> scard(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.scard(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.scard(getKey(key));
    }

    public Response<Long> scard(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.scard(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.scard(getKey(key));
    }

    public Response<String> set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, int time) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.set(getKey(key), value, nxxx, expx, time);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.set(getKey(key), value, nxxx, expx, time);
    }

    public Response<String> set(byte[] key, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.set(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.set(getKey(key), value);
    }

    public Response<String> set(String key, String value, String nxxx, String expx, int time) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.set(getKey(key), value, nxxx, expx, time);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.set(getKey(key), value, nxxx, expx, time);
    }

    public Response<String> set(String key, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.set(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.set(getKey(key), value);
    }

    public Response<Boolean> setbit(byte[] key, long offset, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.setbit(getKey(key), offset, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.setbit(getKey(key), offset, value);
    }

    public Response<Boolean> setbit(String key, long offset, boolean value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.setbit(getKey(key), offset, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.setbit(getKey(key), offset, value);
    }

    public Response<String> setex(byte[] key, int seconds, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.setex(getKey(key), seconds, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.setex(getKey(key), seconds, value);
    }

    public Response<String> setex(String key, int seconds, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.setex(getKey(key), seconds, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.setex(getKey(key), seconds, value);
    }

    public Response<Long> setnx(byte[] key, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.setnx(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.setnx(getKey(key), value);
    }

    public Response<Long> setnx(String key, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.setnx(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.setnx(getKey(key), value);
    }

    public Response<Long> setrange(byte[] key, long offset, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.setrange(getKey(key), offset, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.setrange(getKey(key), offset, value);
    }

    public Response<Long> setrange(String key, long offset, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.setrange(getKey(key), offset, value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.setrange(getKey(key), offset, value);
    }

    public Response<Set<byte[]>> spop(byte[] key, long count) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.spop(getKey(key), count);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.spop(getKey(key), count);
    }

    public Response<byte[]> spop(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.spop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.spop(getKey(key));
    }

    public Response<Set<String>> spop(String key, long count) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.spop(getKey(key), count);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.spop(getKey(key), count);
    }

    public Response<String> spop(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.spop(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.spop(getKey(key));
    }

    public Response<Long> ttl(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.ttl(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.ttl(getKey(key));
    }

    public Response<Long> ttl(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.ttl(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.ttl(getKey(key));
    }

    public Response<String> type(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.type(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.type(getKey(key));
    }

    public Response<String> type(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.type(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.type(getKey(key));
    }

    public Response<Long> zadd(byte[] key, double score, byte[] member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.zadd(getKey(key), score, member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.zadd(getKey(key), score, member);
    }

    public Response<Long> zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.zadd(getKey(key), scoreMembers);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.zadd(getKey(key), scoreMembers);
    }

    public Response<Long> zadd(String key, double score, String member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.zadd(getKey(key), score, member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.zadd(getKey(key), score, member);
    }

    public Response<Long> zadd(String key, Map<String, Double> scoreMembers) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.zadd(getKey(key), scoreMembers);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.zadd(getKey(key), scoreMembers);
    }

    public Response<Long> zcard(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.zcard(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.zcard(getKey(key));
    }

    public Response<Long> zcard(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.zcard(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.zcard(getKey(key));
    }

    public Response<Set<byte[]>> zrange(byte[] key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.zrange(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.zrange(getKey(key), start, end);
    }

    public Response<Set<String>> zrange(String key, long start, long end) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.zrange(getKey(key), start, end);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.zrange(getKey(key), start, end);
    }

    public Response<Boolean> sismember(String key, String member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.sismember(getKey(key), member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.sismember(getKey(key), member);
    }

    public Response<Boolean> sismember(byte[] key, byte[] member) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.sismember(getKey(key), member);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.sismember(getKey(key), member);
    }

    public Response<byte[]> lindex(byte[] key, long index) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lindex(getKey(key), index);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lindex(getKey(key), index);
    }

    public Response<String> lindex(String key, long index) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.lindex(getKey(key), index);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.lindex(getKey(key), index);
    }

    public Response<String> getSet(String key, String value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.getSet(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.getSet(getKey(key), value);
    }

    public Response<byte[]> getSet(byte[] key, byte[] value) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.getSet(getKey(key), value);
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.getSet(getKey(key), value);
    }

    private void sleep() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public void sync() {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                jedisPipeline.sync();
                return;
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        jedisPipeline.sync();
    }

    public Response<Set<String>> smembers(String key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.smembers(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.smembers(getKey(key));
    }

    public Response<Set<byte[]>> smembers(byte[] key) {
        int retryType = retryCount;
        while (retryType > 1) {
            try {
                return jedisPipeline.smembers(getKey(key));
            } catch (Exception e) {
                sleep();
                retryType--;
                continue;
            }
        }
        return jedisPipeline.smembers(getKey(key));
    }
}
