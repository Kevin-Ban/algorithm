package test;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorTest {

    private static String address = "127.0.0.1:2181";

    private static String path = "/test1";

    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(address, retryPolicy);
        client.start();
        InterProcessLock lock = new InterProcessMutex(client, path);
        lock.acquire();
        Thread.sleep(10000);
        lock.release();
        client.close();
    }
}
