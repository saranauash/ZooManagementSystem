public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("City Zoo", "Almaty");
        zoo.openZoo();

        Animal lion = new Mammal("Leo", "Lion", 7);
        Animal elephant = new Mammal("Ella", "Elephant", 12);
        Animal parrot = new Bird("Polly", "Parrot", 5);

        zoo.addAnimal(lion);
        zoo.addAnimal(elephant);
        zoo.addAnimal(parrot);

        zoo.makeAnimalSound(lion);
        zoo.makeAnimalSound(parrot);


        List<Animal> filteredAnimals = zoo.filterAnimalsByAge(8);
        System.out.println("Animals older than 8 years: " + filteredAnimals);


        Animal foundAnimal = zoo.findAnimalByName("Ella");
        System.out.println("Found animal: " + foundAnimal);


        zoo.sortAnimalsByAge();
        zoo.getAnimals().forEach(animal -> System.out.println(animal));
    }
}
