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
        super.before();
    }

    /**
     * 为了防止被 外部调用，可以设为private
     */
    @Override
    public void makeWater() {
        System.out.println("加热.");
    }

    /**
     * 设置钩子，当onlyWater为true时，则不加任何材料
     *
     * @return
     */
    @Override
    public boolean isOnlyWater() {
        return true;
    }
}
