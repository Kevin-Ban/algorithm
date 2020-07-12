package other.test;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        System.out.println(test.test());
        Thread thread = new Thread();
        thread.start();
        Thread.sleep(1);
        System.out.println(thread.getState());
    }

    public String test() {
        String i = "1";
        try {
            i = i + "1";
            return i;
        } catch (Exception e) {
            i = i + "1";
            return i;
        } finally {
            i = i + "1";
            return i;
        }
    }
}
