package _分布式锁._redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

public class RedisLock {
    private String LOCK_KEY = "redis_lock";

    protected long INTERNAL_LOCK_LEASE_TIME = 3;

    private long timeout = 1000;

    private SetParams params = SetParams.setParams().nx().px(INTERNAL_LOCK_LEASE_TIME);

    JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);

    /**
     * 加锁
     *
     * @param id
     * @return
     */
    public boolean  lock(String id) {

        Long start = System.currentTimeMillis();
        Jedis jedis = jedisPool.getResource();
        try {
            while (true) {

                String lock = jedis.set(LOCK_KEY, id, params);
                if ("OK".equals(lock)) {
                    return true;
                }

                long l = System.currentTimeMillis() - start;
                if (l >= timeout) {
                    return false;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            jedis.close();
        }
    }

    /**
     * 解锁
     *
     * @param id
     * @return
     */
    public boolean unlock(String id) {

        Jedis jedis = jedisPool.getResource();
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then" +
                            "  return redis.call('del',KEYS[1])" +
                         "else" +
                         "     return 0 " +
                         "end";
        try {
            String result = jedis.eval(script, Collections.singletonList(LOCK_KEY), Collections.singletonList(id)).toString();
            return "1".equals(result) ? true : false;
        } finally {
            jedis.close();
        }
    }

}
