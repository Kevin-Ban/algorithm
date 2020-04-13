package other.threadPool;

import java.util.concurrent.*;

public class ThreadPoolException {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        Runnable t1 = new ThreadWithException();
//        executorService1.submit(t1);
//        Future result = executorService1.submit(t1);
//        executorService1.execute(t1);
//        executorService1.submit(t1);
        ExecutorService executorService = new MyThreadPool(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executorService.submit(t1);
//        executorService.execute(t1);
//        executorService.execute(t1);
        executorService.shutdownNow();
    }
}

class ThreadWithException implements Runnable, Thread.UncaughtExceptionHandler {

    @Override
    public void run() throws RuntimeException {
        while (true) {
            System.out.println(1);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
    }
}

class MyThreadPool extends ThreadPoolExecutor {

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t == null && r instanceof Future<?>) {
            try {
                Object result = ((Future<?>) r).get();
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset
            }
        }
        if (t != null) {
            System.out.println(t);
        }
    }
}