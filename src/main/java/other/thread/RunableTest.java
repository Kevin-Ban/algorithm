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
    }
}
