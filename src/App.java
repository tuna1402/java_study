class Car {
    String model;
    String fuelType;

    public Car(String model, String fuelType) {
        this.model = model;
        this.fuelType = fuelType;
    }

    public void start() {
        System.out.println(model + "를 운전 합니다.");
    }
}

class Sedan extends Car {

    public Sedan(String model, String fuelType) {
        super(model, fuelType);
    }

    @Override
    public void start() {
        System.out.println(model + " 승용차를 운전합니다.");
    }
}

class Truck extends Car {

    public Truck(String model, String fuelType) {
        super(model, fuelType);
    }

    @Override
    public void start() {
        System.out.println(model + " 화물차를 운전합니다.");
    }
}

class Person {
    String name;
    Car car;

    public Person(String name) {
        this.name = name;
    }

    public void buyCar(Car car) {
        this.car = car;
        System.out.println(name + "이 " + car.model +"를 구입했습니다.");
    }

//     public void drive(Car car) {
//         this.car = car;
//         System.out.println(name + "이 " + car.model +"를 운전합니다.");
//     }

    public void drive() {
        if (car != null) {
            car.start();
        } else {
            System.out.println(name + "이 소유한 차량이 없습니다.");
        }
    }
}

public class App {
    public static void main(String[] args) {
        Car car1 = new Sedan("소나타", "디젤");
        Person person1 = new Person("John");

        person1.buyCar(car1);
        person1.drive();

    }
}