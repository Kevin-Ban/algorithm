package designPattern.decorate;

public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract double cost();

    @Override
    public abstract String getDescription();
}
