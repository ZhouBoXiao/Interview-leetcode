package _分布式锁._zk;

public class ZkLock {
    static int inventory = 10;
    private static final int NUM = 5;

    private static Zk zk = new Zk();

    public static void main(String[] args) {
        try {
            for (int i = 0; i < NUM; i++) {
                new Thread(() -> {
                    try {
                        zk.lock();
                        Thread.sleep(1000);
                        if (inventory > 0) {
                            inventory--;
                        }
                        System.out.println(inventory);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        zk.unlock();
                        System.out.println("释放锁");
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}