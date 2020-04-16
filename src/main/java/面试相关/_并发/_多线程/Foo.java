package 面试相关._并发._多线程;

public class Foo {
    /**
     * 解法四 ： 使用Synchronized
     */

    private boolean firstFinishedd;
    private boolean secondFinished;
    private final Object lock = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinishedd = true;
            lock.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!firstFinishedd) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!secondFinished) {
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    /**
     * 解法三 ： 使用CountDownLatch
     */
    /*private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }*/



    /**
     * 解法二 ： 使用semaphore
     */

    /*public Semaphore  s1 = new Semaphore(0);
    public Semaphore  s2 = new Semaphore(0);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }*/

//    public static void main(String[] args) throws InterruptedException {
//        Foo foo = new Foo();
//        foo.first(() -> {
//            System.out.println("one");
//        });
//        foo.first(() -> {
//            System.out.println("two");
//        });
//        foo.first(() -> {
//            System.out.println("three");
//        });
//    }

/**
 * 解法一 ： 使用volatile，使用两个volatile变量可加快速度，或者 使用AtomicInteger
 */

//    private  volatile  int value =  1;
//
//    public Foo() {
//
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        value = 2;
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        while (value != 2);
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        value = 3;
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        while (value != 3);
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
}
