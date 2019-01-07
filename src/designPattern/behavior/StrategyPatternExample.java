package designPattern.behavior;

public class StrategyPatternExample {
    public static void main(String[] args) {
        RushHourStrategy rushHourStrategy = new RushHourStrategy();
        ReceiptContext receipt1 = new ReceiptContext(2, rushHourStrategy);
        receipt1.calculate();

        HappyHourStrategy happyHourStrategy = new HappyHourStrategy();
        ReceiptContext receipt2 = new ReceiptContext(2, happyHourStrategy);
        receipt2.calculate();
    }
}

class ReceiptContext {
    private double rawPrice;
    private PriceStrategy priceStrategy;
    public ReceiptContext(double rawPrice, PriceStrategy priceStrategy) {
        this.rawPrice = rawPrice;
        this.priceStrategy = priceStrategy;
    }
    void calculate(){
        System.out.println(priceStrategy.execute(rawPrice));
    }
}

interface PriceStrategy{
    double execute(double rawPrice);
}

class RushHourStrategy implements PriceStrategy{
    @Override
    public double execute(double rawPrice) {
        return rawPrice * 2;
        // Many detailed code here, to seperate the implementation of calculation method from Receipt context.
    }
}
class HappyHourStrategy implements PriceStrategy{
    @Override
    public double execute(double rawPrice) {
        return rawPrice * 0.5;
    }
}
