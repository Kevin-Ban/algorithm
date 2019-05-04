package designPattern.template;

import lombok.Data;

@Data
public abstract class DrinkClass {

    /**
     * 钩子，这个属性的值直接决定某些方法是否会执行
     */
    private boolean onlyWater;

    private String name = "饮料";

    public void before(){

    }

    /**
     * 该方法定义为final,禁止子类覆盖,
     * 该方法是模板的总方法，定义了执行的步骤
     */
    public final void getDrink(){
        before();
        System.out.println("正在制作：" + this.name);

        getWater();
        if(!onlyWater){
            getMaterial();
        }
        makeWater();
        System.out.println("-----------------饮料完成-----------------");
    }

    private void getWater(){
        System.out.println("加水");
    }

    /**
     * 这些方法由子类来确定具体的实现
     */
    public abstract void getMaterial();

    public abstract void makeWater();
}
