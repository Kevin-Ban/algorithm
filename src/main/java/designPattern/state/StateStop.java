package designPattern.state;

import lombok.ToString;

@ToString
public class StateStop implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("stop state");
        context.setState(this);
    }
}
