package designPattern.template;

/**
 * 模板方法：大部分方法的实现是一模一样的，只有少部分方法的实现不同
 * 例如：制作饮料时，分为3个步骤：1.加水；2.加材料；3.加热或者加冰
 * 当制作白开水时，不需要加材料；
 * 制作热咖啡时需要加水，加咖啡粉，加热
 * 制作冰红茶时，需要加水，加茶叶，加冰
 */
public class Template {

    public static void main(String[] args) {
        DrinkClass iceTea = new IceTea();
        iceTea.getDrink();

        DrinkClass hotCoffee = new HotCoffee();
        hotCoffee.getDrink();

        DrinkClass water = new Water();
        water.getDrink();
    }
}
