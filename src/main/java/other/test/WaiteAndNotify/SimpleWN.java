package other.test.WaiteAndNotify;

public class SimpleWN {

    final static Object object = new Object();

    public static class T1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ": T1 start.");
                try {
                    System.out.println(System.currentTimeMillis() + ": T1 Wait For Object");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": T1 End!");
            }
        }
    }

    public static class T2 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ": T2 start. notify one other.thread.");
                object.notify();
                System.out.println(System.currentTimeMillis() + ": T2 end.");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
