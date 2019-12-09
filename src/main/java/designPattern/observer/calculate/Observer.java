package designPattern.observer.calculate;

public interface Observer {

    void update(double param1, double param2);

    void showResult();

    double calculate();
}
