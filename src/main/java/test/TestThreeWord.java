package test;

public class TestThreeWord {

    private Thread thread;

    public TestThreeWord(Thread t) {
        this.thread = t;
    }

    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer[] list = new Integer[2];
        list[0] = i;
        list[1] = i;
        i = 2;
    }

    public void start() {
        this.thread.start();
    }
}
