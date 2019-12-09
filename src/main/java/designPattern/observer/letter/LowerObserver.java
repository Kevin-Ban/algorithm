package designPattern.observer.letter;

public class LowerObserver implements Observer {
    @Override
    public void update(String letter) {
        // 将收到的数据转成小写，并输出
        System.out.println("观察者：" + letter.toLowerCase());
    }

}
