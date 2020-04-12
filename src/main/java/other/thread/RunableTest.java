package other.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class RunableTest implements Runnable {

    private Lock lock;

    private Condition condition;

    public RunableTest(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                try {
                    condition.signalAll();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "：测试（Runnable）: " + i);

        }
        lock.unlock();
    }
}
