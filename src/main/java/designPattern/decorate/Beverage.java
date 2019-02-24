package designPattern.decorate;

public abstract class Beverage {

    String description = "Unkonw Beverage";

    public String getDescription(){
        return this.description;
    }

    public abstract double cost();
}
