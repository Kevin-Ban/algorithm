package designPattern.observer.calculate;

import java.util.ArrayList;
import java.util.Optional;

public class Subject {

    private Double param1;

    private Double param2;

    ArrayList<Observer> observers;

    /**
     * 注册观察者
     * @param observer
     * @return
     */
    public boolean registObserver(Observer observer){
        if(observer == null){
            return false;
        }
        this.observers = Optional.ofNullable(this.observers).orElse(new ArrayList<>());
        return this.observers.add(observer);
    }

    /**
     * 注销观察者
     * @param observer
     * @return
     */
    public boolean unRegistObserver(Observer observer){
        if(observer == null){
            return false;
        }
        if(observers == null){
            return true;
        }
        return observers.remove(observer);
    }

    /**
     * 当数据有修改时，统一通知相应的观察者
     */
    private void notifyObserver(){
        if(this.observers != null && !this.observers.isEmpty()){
            for (Observer item : this.observers) {
                item.update(this.param1, this.param2);
            }
        }
    }

    public void changeData(double param1, double param2){
        this.param1 = param1;
        this.param2 = param2;
        // 通知观察者
        notifyObserver();
    }

}
