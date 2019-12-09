package designPattern.observer.letter;

public class Test {

    public static void main(String[] args) {
        // 新建观察者
        Observer low = new LowerObserver();
        Observer up = new UpperObserver();

        // 新建被观察者
        Subject subject = new Subject();

        // 注册观察者，只有注册了观察者，在被观察对象数据有修改时才能收到通知
        subject.registObserver(low);
        subject.registObserver(up);

        // 被观察者修改数据，观察者会收到数据并作出响应的计算并输出结果
        subject.changeData("a");
        System.out.println("------------------");

        // 注销观察者，注销之后观察者不会再收到通知
        subject.unRegistObserver(low);
        subject.changeData("b");
    }
}
