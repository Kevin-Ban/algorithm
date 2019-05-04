package designPattern.template;

public class IceTea extends DrinkClass {
    @Override
    public void getMaterial() {
        System.out.println("加茶叶");
    }

    @Override
    public void makeWater() {
        System.out.println("加冰");
    }
}
