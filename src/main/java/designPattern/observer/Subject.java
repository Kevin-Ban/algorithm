package designPattern.observer;

import java.util.ArrayList;
import java.util.Optional;

public class Subject {

    private double param1;

    private double param2;

    public Subject(double param1, double param2) {
        this.param1 = param1;
        this.param2 = param2;
        notifyObserver();
    }

    public Subject() {
    }

    private ArrayList<Observer> observers;

    public void registerObserver(Observer observer){
        this.observers = Optional.ofNullable(this.observers).orElse(new ArrayList<>());
        observers.add(observer);
    }

    public void unRegisterObserver(Observer observer){
        observers.remove(observer);
    }

    public void changeData(double param1, double param2){
        this.param1 = param1;
        this.param2 = param2;
        notifyObserver();
    }

    public void notifyObserver(){
        if(observers != null && !observers.isEmpty()){
            for (Observer item : observers) {
                item.update(this.param1, this.param2);
            }
        }
    }

}
