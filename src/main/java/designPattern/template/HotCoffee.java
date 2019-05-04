package designPattern.template;

public class HotCoffee extends DrinkClass {

    @Override
    public void getMaterial() {
        System.out.println("加咖啡粉");
    }

    @Override
    public void makeWater() {
        System.out.println("加热");
    }

    @Override
    public void before() {
        this.setName("热咖啡");
    }
}
