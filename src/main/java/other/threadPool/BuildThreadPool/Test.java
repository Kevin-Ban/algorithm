package other.threadPool.BuildThreadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        BetterThreadPool pool = new BetterThreadPool(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        Thread t = new ThreadTest();
        pool.submit(t);
        pool.shutdown();
    }
}

class ThreadTest extends Thread {

    @Override
    public void run() {
        System.out.println(1 / 0);
    }
}
