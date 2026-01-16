public class Reptile extends Animal {
    public Reptile(String name, String species, int age) {
        super(name, species, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " hisses");
    }
}