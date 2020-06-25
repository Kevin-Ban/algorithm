package elasticsearch;

import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        t.addNum(-1);
        t.addNum(-2);
        t.addNum(-3);
        t.addNum(-4);
        t.addNum(-5);
        System.out.println(t.findMedian());
    }

    PriorityQueue<Integer> queue;
    int size;

    /**
     * initialize your data structure here.
     */
    public Test() {
        queue = new PriorityQueue((x, y) -> (int) y - (int) x);
        this.size = 0;
    }

    public void addNum(int num) {
        this.queue.add(num);
        this.size++;
    }

    public double findMedian() {
        if (this.size == 0) {

        }
        Integer[] a = new Integer[queue.size()];
        this.queue.toArray(a);
        int mid = this.size % 2;
        int half = this.size / 2;
        if (mid == 1) {
            return (double) a[half];
        } else {
            return (double) (a[half] + a[half - 1]) / 2.0;
        }
    }
}
