package designPattern.behavior;

import java.util.Stack;

public class MementoPattern {
    public static void main(String[] args) {
        ConcreteOriginator concreteOriginator = new ConcreteOriginator();
        CareTaker careTaker = new CareTaker(concreteOriginator);
        careTaker.setOriginatorState(new State_Originator("Running"));
        System.out.println(careTaker.getOriginatorState().getStateName());
        careTaker.setOriginatorState(new State_Originator("Stopped"));
        careTaker.setOriginatorState(new State_Originator("Running"));
        System.out.println(careTaker.getOriginatorState().getStateName());
        careTaker.undo();
        System.out.println(careTaker.getOriginatorState().getStateName());
        careTaker.undo();
        System.out.println(careTaker.getOriginatorState().getStateName());
    }
}

interface Memento{ //Tag interface: the state of originator before change

}

interface IOriginator {
    public void restore(Memento memento);
    public Memento createMemento();
}


class State_Originator {
    private String stateName;

    public String getStateName() {
        return stateName;
    }

    public State_Originator(String stateName) {
        this.stateName = stateName;

    }
}

/**
 * The thing which changes
 * Concrete Originator can not actively change its state. It does not store the state stack
 */
class ConcreteOriginator implements IOriginator {
    private State_Originator currentState;


    public State_Originator getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State_Originator currentState) {
        this.currentState = currentState;
    }

    //Only the originator can manipulate the memento (retrieve the memento's state)
    @Override
    public Memento createMemento() {
        ConcreteMemento concreteMemento = new ConcreteMemento();
        concreteMemento.setStateOriginator(currentState);
        return concreteMemento;
    }

    @Override
    public void restore(Memento memento) {
        ConcreteMemento concreteMemento = (ConcreteMemento) memento;
        this.currentState = concreteMemento.getStateOriginator();

    }
    //The inner Memento class must be PRIVATE
    private class ConcreteMemento implements Memento{
        private State_Originator stateOriginator;

        public State_Originator getStateOriginator() {
            return stateOriginator;
        }

        public void setStateOriginator(State_Originator stateOriginator) {
            this.stateOriginator = stateOriginator;
        }
    }
}
/**
 * The thing which does impact the change in the originator
 * Keep a stack of memento state
 */
class CareTaker{
    //Memento stack of the originator below
    private Stack<Memento> mementoStack;
    private ConcreteOriginator originator;

    public CareTaker(ConcreteOriginator originator) {
        mementoStack = new Stack<>();
        this.originator = originator;
    }

    public void setOriginatorState(State_Originator stateOriginator){
        mementoStack.push(originator.createMemento());
        originator.setCurrentState(stateOriginator);
    }
    public void undo(){
        originator.restore(mementoStack.pop());
    }
    public State_Originator getOriginatorState() {
        return originator.getCurrentState();
    }

    public void setOriginator(ConcreteOriginator originator) {
        this.originator = originator;
    }
}
