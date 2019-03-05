package designPattern.decorate;

public class Tea extends CondimentDecorator {

    private Beverage beverage;

    public Tea(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 5 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "  tea";
    }
}
