package designPattern;

public class DecoratorPatternExample{
    public static void main(String[] args) {
        PizzaComponent pizzaComponent = new SmallPizza();
        pizzaComponent = new withHam(pizzaComponent);
        pizzaComponent = new withChess(pizzaComponent);
        System.out.println(pizzaComponent.cost());
    }
}

abstract class PizzaComponent{
    abstract int cost();
}

class SmallPizza extends PizzaComponent{
    @Override
    int cost() {
        return 8;
    }
}

class PizzaDecorator extends  PizzaComponent{
    //Composition
    PizzaComponent pizzaComponent; //What to decorate

    public PizzaDecorator(PizzaComponent pizzaComponent) {
        this.pizzaComponent = pizzaComponent;
    }
    @Override
    int cost() {
        return this.pizzaComponent.cost(); // Calculate price of SmallPizza/LargePizza
    }
}

class withHam extends PizzaDecorator{

    public withHam(PizzaComponent pizzaComponent) {
        super(pizzaComponent);
    }
    @Override
    int cost(){
        return super.cost() + 3;
    }
}

class withChess extends PizzaDecorator{
    public withChess(PizzaComponent pizzaComponent){
        super(pizzaComponent);
    }
    @Override
    int cost(){
        return super.cost() + 2;
    }
}