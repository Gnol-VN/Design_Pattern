package designPattern.behavior;

public class TemplatePatternExample {
    public static void main(String[] args) {
        Person student = new Person(17,"single");
        BankAccountTemplate bankAccountTemplate = new StudentCalculation();
        bankAccountTemplate.calculateOpertaion(student);

        Person employee = new Person(27, "Married");
        bankAccountTemplate = new EmployeeCalCulation();
        bankAccountTemplate.calculateOpertaion(employee);

    }
}

abstract class BankAccountTemplate {
    void calculateOpertaion(Person person){
        int age = getAge(person);
        String maritalStatus = getMaritalStatus(person);
        verify(age,maritalStatus);
        System.out.println("Tax value: "+taxCalculate(age, maritalStatus));
        showExclusiveTask();

    }
    //fixed operation
    int getAge(Person person){
        return person.age;
    }
    String getMaritalStatus(Person person){
        return person.maritalStatus;
    };
    //variant operations by each concrete classes
    abstract void verify(int age, String maritalStatus);
    abstract double taxCalculate(int age, String maritalStatus);
    abstract void showExclusiveTask();

}

class StudentCalculation extends BankAccountTemplate {
    @Override
    void verify(int age, String maritalStatus) {
        if(age < 18 && maritalStatus.equalsIgnoreCase("single"))
            System.out.println("Verified student account");
        else System.out.println("Un-verified");
    }

    @Override
    double taxCalculate(int age, String maritalStatus) {
        return 1;
    }

    @Override
    void showExclusiveTask() {
        System.out.println("No exclusive task");
    }
}

class EmployeeCalCulation extends BankAccountTemplate{

    @Override
    void verify(int age, String maritalStatus) {
        if(age > 18 && !maritalStatus.equalsIgnoreCase("single"))
            System.out.println("Verified employee account");
        else System.out.println("Un-verified");
    }

    @Override
    double taxCalculate(int age, String maritalStatus) {
        return 0.8;
    }

    @Override
    void showExclusiveTask() {
        System.out.println("Exclusive task: loan");

    }
}

class Person{
    int age;
    String maritalStatus;

    public Person(int age, String maritalStatus) {
        this.age = age;
        this.maritalStatus = maritalStatus;
    }
}
