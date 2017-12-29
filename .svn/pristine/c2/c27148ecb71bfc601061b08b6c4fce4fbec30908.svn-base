package bonree;

import bonree.proxy.JedisPipelineProxy;
import bonree.proxy.JedisProxy;
import redis.clients.jedis.Response;

/**
 * Created by impala on 2017/8/31.
 */
public class JedisTest {
    public static void main(String[] args) throws Exception {
        JedisProxy jedisProxy = new JedisProxy("3.0", "192.168.101.80:7000");
        System.out.println("ddddd");
        JedisPipelineProxy jedisPipelineProxy = jedisProxy.pipeline();
        jedisPipelineProxy.set("dd", "dd");
        jedisPipelineProxy.sync();
        System.out.println("dddddde");
        Response<String> response = jedisPipelineProxy.get("dd");
        jedisPipelineProxy.sync();
        jedisPipelineProxy.close();
        System.out.println(response.get());
    }
}
