package algorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/print-foobar-alternately/submissions/
 */
public class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                condition.signalAll();
                if (i != n - 1) {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                condition.signalAll();
                if (i != n - 1) {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

// region synchronized

//    public void foo(Runnable printFoo) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            synchronized (this) {
//                // printFoo.run() outputs "foo". Do not change or remove this line.
//                printFoo.run();
//                this.notifyAll();
//                if(i != n - 1) {
//                    this.wait();
//                }
//            }
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            synchronized (this) {
//                // printBar.run() outputs "bar". Do not change or remove this line.
//                printBar.run();
//                this.notifyAll();
//                if (i != n - 1) {
//                    this.wait();
//                }
//            }
//        }
//    }
// endregion