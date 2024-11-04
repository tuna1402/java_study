interface Movable {
    void move();
}

interface Soundable {
    void makeSound();
}

abstract class Animal implements Movable, Soundable{
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sleep() {
        System.out.println(name + "가 잠을 잡니다.");
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println("강아지가 달립니다.");
    }

    @Override
    public void makeSound() {
        System.out.println("멍멍!");
    }

    public void breed() {
        System.out.println("골든 리트리버");
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println("고양이가 살금살금 움직입니다.");
    }

    @Override
    public void makeSound() {
        System.out.println("야옹~");
    }
}

class impCar implements Movable, Soundable {

    @Override
    public void move() {
        System.out.println("차가 도로를 달립니다.");
    }

    @Override
    public void makeSound() {
        System.out.println("빵빵!");
    }
}

public class ClassPracticeTwo {
    public static void main(String[] args) {
        Animal dog = new Dog("dog");
        Animal cat = new Cat("cat");
        impCar car = new impCar();

        dog.move();
        cat.move();
        car.move();

        ((Dog) dog).breed();

        dog.makeSound();
        cat.makeSound();
        car.makeSound();

        dog.sleep();
        cat.sleep();

    }
}