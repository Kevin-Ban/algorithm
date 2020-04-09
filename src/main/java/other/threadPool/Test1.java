package other.threadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("my_thread_%d").build();
        // 任务队列为ArrayBlockingQueue, 可指定大小，当队列中的任务数量大于队列大小时，根据最后一个参数，会拒绝任务新增，并报错
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,
//                1, 0L, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<>(1),
//                threadFactory, new ThreadPoolExecutor.AbortPolicy());
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 3, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(),
                threadFactory, new ThreadPoolExecutor.AbortPolicy());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread2 t3 = new MyThread2();
        MyThread2 t4 = new MyThread2();
        MyThread2 t5 = new MyThread2();

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t4.setName("t4");
        t5.setName("t5");

        poolExecutor.execute(t1);
        poolExecutor.execute(t2);
        poolExecutor.execute(t3);
        poolExecutor.execute(t4);
        poolExecutor.execute(t5);
        poolExecutor.execute(() -> {
            System.out.println("线程类三");
        });
        System.out.println("等待队列中的任务数量：" + poolExecutor.getQueue().size());
        poolExecutor.shutdown();
        Thread.yield();
        Thread.sleep(5000);
        System.out.println("pool is shutdown: " + poolExecutor.isShutdown());
        System.out.println("pool is terminal: " + poolExecutor.isTerminated());

    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("当前线程为：" + Thread.currentThread().getName() + " - " + Thread.currentThread().getId());
    }
}

class MyThread2 extends Thread {

    private CyclicBarrier cyclicBarrier;

    public MyThread2(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public MyThread2() {

    }

    @Override
    public void run() {
        System.out.println("线程类2：当前线程为：" + Thread.currentThread().getName() + " - " + Thread.currentThread().getId());
        if (cyclicBarrier != null) {
            try {
                System.out.println("sleep " + 3 + "秒");
                Thread.sleep(3000);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
