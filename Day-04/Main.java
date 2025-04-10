class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println(name + " the Dog says: Woof Woof!");
    }
}

class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println(name + " the Cat says: Meow!");
    }
}

class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println(name + " the Bird says: Tweet Tweet!");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog("Buddy", 3);
        Cat c = new Cat("Whiskers", 2);
        Bird b = new Bird("Tweety", 1);

        d.makeSound();
        c.makeSound();
        b.makeSound();
    }
}
