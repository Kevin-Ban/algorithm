package other.threadPool.BuildThreadPool;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

public class BetterArrayQueue<E> extends ArrayBlockingQueue<E> {

    private BetterThreadPool executor;

    public BetterArrayQueue(int capacity, BetterThreadPool executor) {
        super(capacity);
        this.executor = executor;
    }

    public BetterArrayQueue(int capacity, boolean fair, BetterThreadPool executor) {
        super(capacity, fair);
        this.executor = executor;
    }

    public BetterArrayQueue(int capacity, boolean fair, Collection<? extends E> c, BetterThreadPool executor) {
        super(capacity, fair, c);
        this.executor = executor;
    }

    @Override
    public boolean offer(E o) {

        int currentPoolThreadSize = executor.getPoolSize();

        //如果线程池里的线程数量已经到达最大,将任务添加到队列中
        if (currentPoolThreadSize == executor.getMaximumPoolSize()) {
            return super.offer(o);
        }
        //说明有空闲的线程,这个时候无需创建core线程之外的线程,而是把任务直接丢到队列里即可
//        if (executor.getSubmittedTaskCount() < currentPoolThreadSize) {
//            return super.offer(o);
//        }

        //如果线程池里的线程数量还没有到达最大,直接创建线程,而不是把任务丢到队列里面
        if (currentPoolThreadSize < executor.getMaximumPoolSize()) {
            return false;
        }

        return super.offer(o);
    }
}
