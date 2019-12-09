package designPattern.observer.letter;

public class UpperObserver implements Observer {
    @Override
    public void update(String letter) {
        // 将收到的数据转成大写，并输出
        System.out.println("观察者：" + letter.toUpperCase());
    }
}
