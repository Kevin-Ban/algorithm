package designPattern.template;

public class Water extends DrinkClass {

    /**
     * 为了防止被 外部调用，可以设为private
     */
    @Override
    public void getMaterial() {

    }

    /**
     * 为了防止被 外部调用，可以设为private
     */
    @Override
    public void makeWater() {
        // 设置钩子，当onlyWater为true时，则不加任何材料
        this.setOnlyWater(true);
        System.out.println("白开水, 加热.");
    }
}
