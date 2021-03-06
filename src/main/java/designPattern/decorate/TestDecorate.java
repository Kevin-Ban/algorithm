package designPattern.decorate;

public class TestDecorate {

    public static void main(String[] args){
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
        beverage = new Tea(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());
    }
}
