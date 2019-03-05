package designPattern.strategy;

public class TestStrategy {

    public static void main(String[] args){
        OperateSub sub = new OperateSub(9, 10);
        OperateAdd add = new OperateAdd(9, 10);

        System.out.println(sub.calculate());
        System.out.println(add.calculate());
    }
}
