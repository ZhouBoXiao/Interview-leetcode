package _多线程编程._1195_交替打印字符串;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/4 10:57
 */
public class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition fizzCondition = lock.newCondition();
    private Condition buzzCondition = lock.newCondition();
    private Condition fizzbuzzCondition = lock.newCondition();
    private Condition numberCondition = lock.newCondition();
    private int i = 1;

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try{
            if(i % 3 != 0){
                fizzCondition.await();
            }
            for(; i <= n;){
                printFizz.run();
                numberCondition.signal();
                fizzCondition.await();
            }
        }finally{
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try{
            if(i % 5 != 0){
                buzzCondition.await();
            }
            for(; i <= n;){
                printBuzz.run();
                numberCondition.signal();
                buzzCondition.await();
            }
        }finally{
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try{
            if(i % 3 != 0 || i % 5 != 0){
                fizzbuzzCondition.await();
            }
            for(; i <= n;){
                printFizzBuzz.run();
                numberCondition.signal();
                fizzbuzzCondition.await();
            }
        }finally{
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try{
            for(; i <= n; i++){
                if(i % 3 != 0 && i % 5 != 0){
                    printNumber.accept(i);
                }else if(i % 3 == 0 && i % 5 != 0){
                    fizzCondition.signal();
                    numberCondition.await();
                }else if(i % 3 != 0 && i % 5 == 0){
                    buzzCondition.signal();
                    numberCondition.await();
                }else{
                    fizzbuzzCondition.signal();
                    numberCondition.await();
                }
            }
            fizzCondition.signal();
            buzzCondition.signal();
            fizzbuzzCondition.signal();
        }finally{
            lock.unlock();
        }
    }
}
class FizzBuzz1 {
    private int n;
    int curr = 1;

    public FizzBuzz1(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {

        synchronized(this){
            while(curr <= n){
                if(curr%3 == 0 && curr%5 != 0){
                    printFizz.run();
                    curr++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {

        synchronized(this){
            while(curr <= n){
                if(curr%3 != 0 && curr%5 == 0){
                    printBuzz.run();
                    curr++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        synchronized(this){
            while(curr <= n){
                if(curr%3 == 0 && curr%5 == 0){
                    printFizzBuzz.run();
                    curr++;
                    notifyAll();
                } else{
                    wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

        synchronized(this){
            while(curr <= n){
                if(curr%3 != 0 && curr%5 != 0){
                    printNumber.accept(curr);
                    curr++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }
    }
}