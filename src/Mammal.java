public class Mammal extends Animal {
    public Mammal(String name, String species, int age) {
        super(name, species, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " roars!");
    }
}