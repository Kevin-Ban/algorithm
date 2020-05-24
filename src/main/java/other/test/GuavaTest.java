package other.test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class GuavaTest {
    public static void main(String[] args) throws ExecutionException {
        Map<String, String> map = new HashMap<>();
        map.put("test", "123");
        Cache<String, String> cache = CacheBuilder.newBuilder().build();
        System.out.println(cache.get("test1", new MyCallable("test1", map)));
        System.out.println(cache.get("test1", new MyCallable("test1", map)));
    }


    public static void main1(String[] args) {
//        RateLimiter limiter = RateLimiter.create(50);
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);
//
//        for (int i = 0; i < 100; i++) {
//            Runnable t = new Runnable() {
//                @Override
//                public void run() {
//                    double r = limiter.acquire();
//                    System.out.println(Thread.currentThread().getName() + ":" + r);
//                }
//            };
//            executor.submit(t);
//        }
        int size = 100000;
        List<SoftReference<String>> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new SoftReference<>("软引用--------->" + i));
        }
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }

    }
}

class MyCallable implements Callable {

    private String key;
    private Map<String, String> otherDataSource;

    public MyCallable(String key, Map<String, String> otherDataSource) {
        this.key = key;
        this.otherDataSource = otherDataSource;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("读取其他数据源的数据");
        return otherDataSource.get(key) == null ? "null" : otherDataSource.get(key);
    }
}