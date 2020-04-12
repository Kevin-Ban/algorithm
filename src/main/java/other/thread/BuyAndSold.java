package other.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BuyAndSold {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        List<String> ticket = new ArrayList<>(10);
        int times = 2;
        Sold sold = new Sold("sold", lock, condition, ticket, times);
        Buy buy = new Buy("buy", lock, condition, ticket, times);
        buy.start();
        sold.start();
        Thread.sleep(1);
    }
}

class Buy extends Thread {

    private Lock lock;

    private Condition condition;

    private List<String> ticket;

    private int times;

    /**
     * 买票的线程
     *
     * @param name      线程名称
     * @param lock      锁
     * @param condition 信号
     * @param ticket    票
     * @param times     每天放票的次数
     */
    public Buy(String name, Lock lock, Condition condition, List<String> ticket, int times) {
        this.lock = lock;
        this.condition = condition;
        this.ticket = ticket;
        this.setName(name);
        this.times = times;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < times; i++) {
                System.out.println("买票");
                if (ticket == null || ticket.isEmpty()) {
                    System.out.println("票不够了，通知影院补票，并且暂停售票");
                    condition.signalAll();
                    condition.await();
                }
                System.out.println("开始售票");
                Iterator<String> iterator = ticket.iterator();
                while (iterator.hasNext()) {
                    System.out.println("买到的票号 : " + iterator.next());
                    iterator.remove();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Sold extends Thread {

    private Lock lock;

    private Condition condition;

    private List<String> ticket;

    private int times;

    public Sold(String name, Lock lock, Condition condition, List<String> ticket, int times) {
        this.lock = lock;
        this.condition = condition;
        this.ticket = ticket;
        this.times = times;
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            lock.lock();
            for (int j = 0; j < times; j++) {
                System.out.println("补票");
                for (int i = 0; i < 5; i++) {
                    System.out.println("补充的票号：" + i);
                    ticket.add(i + "");
                }
                System.out.println("补好票了，你卖票吧");
                condition.signalAll();
                // **** 特别重要，当达到最大的放票次数之后，就不需要让补票的线程继续等待，直接关闭即可
                // 如果没有达到最大的放票次数，则让补票的线程等待票被卖完才能继续补票
                // 如果没有这个条件，那么补票的线程会一直处于等待状态，整个程序无法结束
                if (j < times - 1) {
                    condition.await();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}