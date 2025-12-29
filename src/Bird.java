public class Bird extends Animal {
    public Bird(String name, String species, int age) {
        super(name, species, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " chirps!");
    }
}