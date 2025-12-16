public class Main {

    public static void main(String[] args) {

        Animal lion = new Animal("Leo", "Lion", 5);
        Animal elephant = new Animal("Ella", "Elephant", 10);

        Zookeeper zookeeper = new Zookeeper("John", 7);
        Zoo zoo = new Zoo("City Zoo", "Almaty");

        System.out.println(lion);
        System.out.println(elephant);
        System.out.println(zookeeper);
        System.out.println(zoo);

        lion.makeSound();
        zookeeper.feedAnimal(elephant);
        zoo.openZoo();

        if (lion.getAge() > elephant.getAge()) {
            System.out.println(lion.getName() + " is older than " + elephant.getName());
        } else {
            System.out.println(elephant.getName() + " is older than " + lion.getName());
        }
    }
}
