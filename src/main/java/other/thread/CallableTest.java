package other.thread;

import java.util.concurrent.Callable;

/**
 * Callable<T>内可以定义返回的类型
 */
public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "：测试（Callable）");
        Thread.sleep(20000);
        return "返回结果";
    }
}
