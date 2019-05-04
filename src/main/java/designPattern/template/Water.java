package designPattern.template;

public class Water extends DrinkClass {

    /**
     * 为了防止被 外部调用，可以设为private
     */
    @Override
    public void getMaterial() {

    }

    @Override
    public void before() {
        this.setName("白开水");
    }

    /**
     * 为了防止被 外部调用，可以设为private
     */
    @Override
    public void makeWater() {
        // 设置钩子，当onlyWater为true时，则不加任何材料
        System.out.println("白开水, 加热.");
    }

    @Override
    public boolean isOnlyWater() {
        return true;
    }
}
