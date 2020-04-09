package other.thread;

public class ThreadTest extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 测试（Thread）");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程运行完毕");
    }
}
