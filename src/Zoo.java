import java.util.*;

public class Zoo {
    private String zooName;
    private String location;
    private List<Animal> animals;

    public Zoo(String zooName, String location) {
        this.zooName = zooName;
        this.location = location;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void makeAnimalSound(Animal animal) {
        animal.makeSound();
    }

    public List<Animal> filterAnimalsByAge(int ageLimit) {
        List<Animal> filteredAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getAge() > ageLimit) {
                filteredAnimals.add(animal);
            }
        }
        return filteredAnimals;
    }

    public Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public void sortAnimalsByAge() {
        animals.sort(Comparator.comparingInt(Animal::getAge));
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void openZoo() {
        System.out.println(zooName + " is open in " + location);
    }

    @Override
    public String toString() {
        return "Zoo{name='" + zooName + "', location='" + location + "'}";
    }
}
