package designPattern.template;

import lombok.Data;

@Data
public abstract class DrinkClass {

    private boolean onlyWater;

    /**
     * 该方法定义为final,禁止子类覆盖,
     * 该方法是模板的总方法，定义了执行的步骤
     */
    public final void getDrink(){
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

    public abstract void getMaterial();

    public abstract void makeWater();
}
