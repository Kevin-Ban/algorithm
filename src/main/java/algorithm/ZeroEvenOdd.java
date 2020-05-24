package algorithm;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        };
        Thread zero = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                zeroEvenOdd.zero(intConsumer);
            }
        });
        Thread odd = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                zeroEvenOdd.odd(intConsumer);
            }
        });
        Thread even = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                zeroEvenOdd.even(intConsumer);
            }
        });

        zero.start();
        odd.start();
        even.start();
    }

    Lock lock = new ReentrantLock();
    Condition zero = lock.newCondition();
    Condition even = lock.newCondition();
    Condition odd = lock.newCondition();

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i <= n; i++) {
            lock.lock();
            try {
                if (i == 0) {
                    printNumber.accept(0);
                    even.signalAll();
                    odd.signalAll();
                    zero.await();
                } else {
                    printNumber.accept(0);
                    if (i % 2 == 0) {
                        odd.signalAll();
                    }
                    if (i % 2 == 1) {
                        even.signalAll();
                    }
                    zero.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i <= n; i++) {
            lock.lock();
            try {
                if (i == 0) {
                    zero.signalAll();
                    even.await();
                } else if (i % 2 == 0) {
                    printNumber.accept(i);
                    zero.signalAll();
                    even.await();
                }
            } finally {
                lock.unlock();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i <= n; i++) {
            lock.lock();
            try {
                if (i == 0) {
                    zero.signalAll();
                    odd.await();
                }
                if (i % 2 == 1) {
                    printNumber.accept(i);
                    zero.signalAll();
                    odd.await();
                }

            } finally {
                lock.unlock();
            }
        }
    }
}