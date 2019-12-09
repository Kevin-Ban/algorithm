package designPattern.observer.calculate;

public class TestObserver {

    public static void main(String[] args){
        Subject subject = new Subject();
        Observer add = new ObserverAdd();
        Observer sub = new ObserverSub();
        subject.registObserver(sub);
        subject.registObserver(add);

        subject.changeData(9, 16);
    }
}
