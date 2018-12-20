package designPattern;

public class StatePatternExample {
    public static void main(String[] args) {
        FanContext fanContext = new FanContext();
        LowSpeedFan lowSpeedFan = new LowSpeedFan();
        lowSpeedFan.handle(fanContext);

        HighSpeedFan highSpeedFan = new HighSpeedFan();
        highSpeedFan.handle(fanContext);
    }
}

class FanContext {
    private State currentState;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
interface State{
    void handle(FanContext fanContext);
}

class LowSpeedFan implements State{
    @Override
    public void handle(FanContext fanContext) {
        fanContext.setCurrentState(this);
        System.out.println("Changed to low speed");
        // Many detailed code here, to seperate the implementation of behavious of state from a Fan
    }
}

class HighSpeedFan implements State{
    @Override
    public void handle(FanContext fanContext) {
        fanContext.setCurrentState(this);
        System.out.println("Changed to high spepd");
        // Many detailed code here, to seperate the implementation of behavious of state from a Fan

    }
}
