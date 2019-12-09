package designPattern.observer.letter;

import java.util.ArrayList;
import java.util.Optional;

public class Subject {
    /**
     * 观察者集合
     */
    private ArrayList<Observer> observers;

    /**
     * 注册观察者
     *
     * @param observer
     * @return
     */
    public boolean registObserver(Observer observer) {
        if (observer == null) {
            return false;
        }
        this.observers = Optional.ofNullable(this.observers).orElse(new ArrayList<>());
        return this.observers.add(observer);
    }

    /**
     * 注销观察者
     *
     * @param observer
     * @return
     */
    public boolean unRegistObserver(Observer observer) {
        if (observer == null) {
            return false;
        }
        if (observers == null) {
            return true;
        }
        return observers.remove(observer);
    }

    /**
     * 当数据有修改时，统一通知相应的观察者
     */
    private void notifyObserver(String letter) {
        if (this.observers != null && !this.observers.isEmpty()) {
            for (Observer item : this.observers) {
                item.update(letter);
            }
        }
    }

    /**
     * 修改数据
     *
     * @param letter
     */
    public void changeData(String letter) {
        System.out.println("被观察者：" + letter);
        // 通知观察者
        notifyObserver(letter);
    }
}
