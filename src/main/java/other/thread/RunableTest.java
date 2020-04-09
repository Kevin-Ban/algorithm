package other.thread;

public class RunableTest implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：测试（Runnable）");
    }
}
