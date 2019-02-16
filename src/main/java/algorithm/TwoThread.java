package algorithm;

public class TwoThread {

    public static void main(String[] args) throws InterruptedException {
        int[] evenArray = new int[]{ 2,4,6,8,10 };
        int[] oddArray = new int[]{ 1,3,5,7,9 };
        EvenClass e = new EvenClass(evenArray);
        EvenClass o = new EvenClass(oddArray);
        Thread t = new Thread(e);
        Thread t1 = new Thread(o);
        t1.start();
        t.start();
    }

}
class EvenClass implements Runnable{

    private int[] evenArray;

    public EvenClass(int[] array){
        this.evenArray = array;
    }
    @Override
    public void run() {
        for (int i : evenArray) {
            synchronized (this) {
                notify();
                System.out.println(i);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
