package designPattern.state;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();

        StateStart startState = new StateStart();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StateStop stopState = new StateStop();
        stopState.doAction(context);

        System.out.println(context.getState().toString());

    }
}
