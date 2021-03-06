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

    /**
     * 设置钩子
     * @return
     */
    @Override
    public boolean isOnlyWater() {
        return false;
    }

    @Override
    public void before() {
        this.setName("热咖啡");
        super.before();
    }
}
