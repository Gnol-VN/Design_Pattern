package designPattern.behavior;

public class MementoPattern {
    public static void main(String[] args) {

    }
}

interface Memento{

}

interface Originator{
    public void restore(Memento memento);
    public void createMemento();
}

class ConcreteOriginator implements Originator{

    @Override
    public void restore(Memento memento) {

    }

    @Override
    public void createMemento() {

    }

    class ConcreteMemento implements Memento{

    }
}

class CareTaker{

}
