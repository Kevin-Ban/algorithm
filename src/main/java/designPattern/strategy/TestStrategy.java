package designPattern.strategy;

public class TestStrategy {

    public static void main(String[] args){
        Operation sub = new OperateSub(9, 10);
        Operation add = new OperateAdd(9, 10);

        System.out.println(sub.calculate());
        System.out.println(add.calculate());
    }
}
