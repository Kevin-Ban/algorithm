package designPattern.observer.calculate;

public class ObserverAdd implements Observer {

    private Double param1;

    private Double param2;

    @Override
    public void update(double param1, double param2) {
        this.param1 = param1;
        this.param2 = param2;
        showResult();
    }

    @Override
    public void showResult() {
        System.out.println(calculate());
    }

    @Override
    public double calculate() {
        if(this.param2 != null && this.param1 != null) {
            return this.param1 + this.param2;
        }
        return 0;
    }
}
