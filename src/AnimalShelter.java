import java.util.LinkedList;
import java.util.Queue;

// Animal CLass
    abstract class Animal {
        private String name;
        private int order;

    public Animal(String name) {
        this.name = name;
    }


    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public boolean isOlderThan(Animal other) {
        return this.order < other.order;
    }

    @Override
    public String toString() {
        return "Animal{" + "name=" + name + ", order=" + order + '}';
    }
}

// Dog Class
    class Dog extends Animal {
        public Dog(String name) {
            super(name);
    }
}

// Cat Class
    class Cat extends Animal {
        public Cat(String name) {
            super(name);
    }
}

// Animal Shelter Class
    class AnimalShelter {
        private Queue<Dog> dogs;
        private Queue<Cat> cats;
        private int orderCounter = 0;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

// Enqueue an animal
    public void enqueue(Animal animal) {
        animal.setOrder(++orderCounter);

        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.add((Cat) animal);
        }
    }

// Dequeue the oldest animal
    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) return null;
        if (dogs.isEmpty()) return dequeueCat();
        if (cats.isEmpty()) return dequeueDog();

        Dog oldestDog = dogs.peek();
        Cat oldestCat = cats.peek();

        if (oldestDog.isOlderThan(oldestCat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
    }
}

// Dequeue oldest dog
    public Dog dequeueDog() {
    return dogs.poll();
    }

// Dequeue oldest cat
    public Cat dequeueCat() {
        return cats.poll();
    }

// Display queue state
    public void displayShelter() {
        System.out.println("Dogs in shelter: " + dogs);
        System.out.println("Cats in shelter: " + cats);
    }
}

    class AnimalShelterDemo {
        public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Dog("Rocky"));
        shelter.enqueue(new Cat("Simba"));
        shelter.enqueue(new Dog("Muffin"));
        shelter.enqueue(new Cat("Nala"));

        shelter.displayShelter();

        System.out.println("Adopting any: " + shelter.dequeueAny());
        System.out.println("Adopting a dog: " + shelter.dequeueDog());
        System.out.println("Adopting a cat: " + shelter.dequeueCat());

        shelter.displayShelter();
        }
    }