package designPattern.strategy;

public class OperateSub implements Operation {

    private double firstParam;

    private double secondParam;

    public OperateSub(double firstParam, double secondParam){
        this.firstParam = firstParam;
        this.secondParam = secondParam;
    }

    @Override
    public double calculate() {
        return firstParam - secondParam;
    }
}
