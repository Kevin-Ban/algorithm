package designPattern.strategy;

public class OperateAdd implements Operation {

    private double firstParam;

    private double secondParam;

    public OperateAdd(double firstParam, double secondParam){
        this.firstParam = firstParam;
        this.secondParam = secondParam;
    }

    @Override
    public double calculate() {
        return firstParam + secondParam;
    }
}
