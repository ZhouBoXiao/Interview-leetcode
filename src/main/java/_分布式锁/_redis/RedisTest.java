package _分布式锁._redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RedisTest {
    private static Integer inventory = 1001;
    private static final int NUM = 1000;
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

    public static void main(String[] args) {

        TimeUnit unit;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory,
                inventory, 10L, SECONDS, linkedBlockingQueue);
        long start = System.currentTimeMillis();

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        final RedissonClient client = Redisson.create(config);
        final RLock lock = client.getLock("lock1");
        for (int i = 0; i <= NUM; i++) {
            threadPoolExecutor.execute(() -> {
                        lock.lock();
                        inventory--;
                        System.out.println(inventory);
                        lock.unlock();
                    }
            );
        }
        long end = System.currentTimeMillis();
        System.out.println("执行线程数:" + NUM + "   总耗时:" + (end - start) + "  库存数为:" + inventory);
    }
}
