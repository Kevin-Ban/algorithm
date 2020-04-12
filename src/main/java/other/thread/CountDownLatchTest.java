package other.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch是一种线程控制的数据结构，它可以设置线程的数量，只有在线程内调用了n次java.util.concurrent.CountDownLatch#countDown()方法
 * 计数器才会进行减1操作，当计数器被减为0之后，才会执行接下来的指定的任务
 */
public class CountDownLatchTest implements Runnable {

    private static final CountDownLatch end = new CountDownLatch(10);

    private static final CountDownLatchTest test = new CountDownLatchTest();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(test);
        }
        // 计数器等待检查
        end.await();
        System.out.println("前面10个线程已经执行完毕，现在可以执行主线程了");
        executorService.shutdown();
        System.out.println("主线程任务开始....");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println(" complete. ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // **** 重要，这里相当于计数，通知计数器有一个线程已经执行完毕
            end.countDown();
        }
    }
}
