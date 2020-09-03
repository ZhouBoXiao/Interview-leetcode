package _多线程编程._1115_交替打印FooBar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    int val = 1;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (val != 1) {
                    condition.await();
                }
                printFoo.run();
                val = 2;
                condition.signal();
            } finally {
                lock.unlock();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            //printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try{

                while (val != 2) {
                    condition.await();
                }
                printBar.run();
                val = 1;

                condition.signal();
            } finally {
                lock.unlock();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            //printBar.run();
        }
    }
}
