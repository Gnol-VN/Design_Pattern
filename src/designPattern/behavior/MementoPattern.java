package designPattern.behavior;

import java.util.Stack;

public class MementoPattern {
    public static void main(String[] args) {
        ConcreteOriginator concreteOriginator = new ConcreteOriginator();
        CareTaker careTaker = new CareTaker(concreteOriginator);

        careTaker.setOriginatorState(new OriginatorState("Running"));
        System.out.println(careTaker.getOriginatorState().getStateName());
        careTaker.setOriginatorState(new OriginatorState("Stopped"));
        System.out.println(careTaker.getOriginatorState().getStateName());
        careTaker.undo();
        System.out.println(careTaker.getOriginatorState().getStateName());

    }
}

interface Memento{ //Tag interface: the state of originator before change

}

interface Originator{ // The thing which changes
    public void restore(Memento memento);
    public Memento createMemento();
}


class OriginatorState{
    private String stateName;

    public String getStateName() {
        return stateName;
    }

    public OriginatorState(String stateName) {
        this.stateName = stateName;

    }
}
class ConcreteOriginator implements Originator{
    private OriginatorState currentState;


    public OriginatorState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(OriginatorState currentState) {
        this.currentState = currentState;
    }

    //Only the originator can manipulate the memento (retrieve the memento's state)
    @Override
    public Memento createMemento() {
        ConcreteMemento concreteMemento = new ConcreteMemento();
        concreteMemento.setOriginatorState(currentState);
        return concreteMemento;
    }

    @Override
    public void restore(Memento memento) {
        ConcreteMemento concreteMemento = (ConcreteMemento) memento;
        this.currentState = concreteMemento.getOriginatorState();

    }

    class ConcreteMemento implements Memento{
        private OriginatorState originatorState;

        public OriginatorState getOriginatorState() {
            return originatorState;
        }

        public void setOriginatorState(OriginatorState originatorState) {
            this.originatorState = originatorState;
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

    public void setOriginatorState(OriginatorState originatorState){
        mementoStack.push(originator.createMemento());
        originator.setCurrentState(originatorState);
    }
    public void undo(){
        originator.restore(mementoStack.pop());
    }
    public OriginatorState getOriginatorState() {
        return originator.getCurrentState();
    }

    public void setOriginator(ConcreteOriginator originator) {
        this.originator = originator;
    }
}
