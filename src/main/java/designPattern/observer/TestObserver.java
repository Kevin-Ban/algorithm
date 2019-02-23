package designPattern.observer;

public class TestObserver {

    public static void main(String[] args){
        Subject subject = new Subject();
        Observer addObserver = new AddObserver();
        Observer subObserver = new SubObserver();
        subject.registerObserver(subObserver);
        subject.registerObserver(addObserver);
        subject.changeData(2, 6);

        subject.unRegisterObserver(subObserver);
        subject.changeData(5, 6);
    }
}
