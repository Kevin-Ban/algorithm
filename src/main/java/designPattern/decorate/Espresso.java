package designPattern.decorate;

public class Espresso extends Beverage {

    public Espresso(){
        this.description = "Espreeso";
    }

    @Override
    public double cost() {
        return 2;
    }
}
