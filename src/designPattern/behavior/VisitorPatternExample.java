package designPattern.behavior;

public class VisitorPatternExample {
    public static void main(String[] args) {
        TripVisitor londonVisitor = new LondonVisitor();
        TripVisitor hanoiVisitor = new HanoiVisitor();
        Vehicle plane = new Plane();
        Vehicle car = new Car();

        plane.accept(londonVisitor);
        plane.accept(hanoiVisitor);
        car.accept(londonVisitor);
        car.accept(hanoiVisitor);
    }
}

interface TripVisitor {
    void visit(Plane plane);
    void visit(Car car);
}

class LondonVisitor implements TripVisitor {
    @Override
    public void visit(Plane plane) {
        System.out.println("Go to London by " + plane.getClass().getSimpleName());
    }
    @Override
    public void visit(Car car) {
        System.out.println("Go to London by " + car.getClass().getSimpleName());
    }
}

class HanoiVisitor implements TripVisitor{
    @Override
    public void visit(Plane plane) {
        System.out.println("Go to Hanoi by " + plane.getClass().getSimpleName());
    }
    @Override
    public void visit(Car car) {
        System.out.println("Go to Hanoi by "+ car.getClass().getSimpleName());
    }
}
class BeijingVisitor implements TripVisitor{

    @Override
    public void visit(Plane plane) {

    }

    @Override
    public void visit(Car car) {

    }
}

interface Vehicle {
    void accept(TripVisitor tripVisitor);
}

class Car implements Vehicle {
    @Override
    public void accept(TripVisitor tripVisitor) {
        tripVisitor.visit(this);
    }

}

class Plane implements Vehicle {
    @Override
    public void accept(TripVisitor tripVisitor) {
        tripVisitor.visit(this);
    }
}




