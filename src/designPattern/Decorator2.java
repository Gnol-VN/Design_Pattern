package designPattern;

public class Decorator2 {
    public static void main(String[] args) {
        SalesOrder salesOrder = new UKTax();
        salesOrder = new withHeader(salesOrder);
        salesOrder = new withHeader(salesOrder);
        salesOrder = new withHeader(salesOrder);
        salesOrder = new withFooter(salesOrder);
        salesOrder = new withHeader(salesOrder);
        System.out.println(salesOrder.printTicket());
    }
}

abstract class SalesOrder{
    abstract String printTicket();
}

abstract class CalcTax extends SalesOrder{

}
class USTax extends CalcTax{

    @Override
    String printTicket() {
        return "US tax";
    }
}
class UKTax extends CalcTax{

    @Override
    String printTicket() {
        return "UK tax";
    }
}
abstract class SalesTicket extends SalesOrder{
    SalesOrder salesOrder;

    public SalesTicket(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    @Override
    String printTicket() {
        return salesOrder.printTicket();
    }
}

class withHeader extends SalesTicket{
    withHeader(SalesOrder salesOrder){
        super(salesOrder);
    }

    String printTicket(){
        return super.printTicket() + "With Header";
    }
}
class withFooter extends SalesTicket{
    withFooter(SalesOrder salesOrder){
        super(salesOrder);
    }
    String printTicket(){
        return super.printTicket() + "With Footer";
    }
}
