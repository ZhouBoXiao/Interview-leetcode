package _分布式锁._zk;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Zk implements Lock{
    private static CountDownLatch cdl = new CountDownLatch(1);

    private static final String IP_PORT = "127.0.0.1:2181";
    private static final String Z_NODE = "/LOCK";

    private volatile String beforePath;
    private volatile String path;

    private ZkClient zkClient = new ZkClient(IP_PORT);

    public Zk() {
        if (!zkClient.exists(Z_NODE)) {
            zkClient.createPersistent(Z_NODE);
        }
    }

    @Override
    public void lock() {
        if (tryLock()) {
            System.out.println("获得锁");
        } else {
            // 尝试加锁
            // 进入等待 监听
            waitForLock();
            // 再次尝试
            lock();
        }
    }
    public void waitForLock() {

        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println(Thread.currentThread().getName() + ":监听到节点删除事件！---------------------------");
                cdl.countDown();
            }
        };
        // 监听
        this.zkClient.subscribeDataChanges(beforePath, listener);
        if (zkClient.exists(beforePath)) {
            try {
                System.out.println("加锁失败 等待");
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 释放监听
        zkClient.unsubscribeDataChanges(beforePath, listener);
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        if (StringUtils.isBlank(path)) {
            path = zkClient.createEphemeralSequential(Z_NODE + "/", "lock");
        }
        // 对节点排序
        List<String> children = zkClient.getChildren(Z_NODE);
        Collections.sort(children);
        // 当前的是最小节点就返回加锁成功
        if (path.equals(Z_NODE + "/" + children.get(0))) {
            System.out.println(" i am true");
            return true;
        } else {
            // 不是最小节点 就找到自己的前一个 依次类推 释放也是一样
            int i = Collections.binarySearch(children, path.substring(Z_NODE.length() + 1));
            beforePath = Z_NODE + "/" + children.get(i - 1);
        }

        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        zkClient.delete(path);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
