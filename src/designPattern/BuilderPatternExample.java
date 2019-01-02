package designPattern;
public class BuilderPatternExample {
    public static void main(String[] args) {
        Car car1 = new Car.Builder().setType("Sport car").setWheel(4)
                .build();
        Car car2 = new Car.Builder().setWheel(6).setType("Container")
                .build();
        System.out.println(car1);
        System.out.println(car2);
    }
}

class Car {
    private int wheel;
    private String type;

    private Car() {
    }

    public static class Builder {
        private int wheel;
        private String type;

        public Builder() {
        }

        public Car build(){
            Car car = new Car();
            car.type = this.type;
            car.wheel = this.wheel;
            return car;
        }
        public Builder setWheel(int wheel){
            this.wheel = wheel;
            return this;
        }

        public Builder setType(String color){
            this.type = color;
            return this;
        }
    }

    public String toString() {
        return "Type: " + type + ", wheel: " + wheel;
    }
}


