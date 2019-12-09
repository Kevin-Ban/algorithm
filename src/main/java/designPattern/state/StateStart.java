package designPattern.state;

import lombok.ToString;

@ToString
public class StateStart implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("start state.");
        context.setState(this);
    }
}
