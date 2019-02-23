package designPattern.observer;

public class SubObserver implements Observer {

    private double param1;

    private  double param2;

    @Override
    public void update(double param1, double param2) {
        this.param1 = param1;
        this.param2 = param2;
        showResult();
    }

    @Override
    public void showResult() {
        System.out.println("\r" + "两数相减的结果为：" + (param1 - param2));
    }
}
