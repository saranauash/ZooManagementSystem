public class Zookeeper {

    private String name;
    private int experienceYears;

    public Zookeeper(String name, int experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void feedAnimal(Animal animal) {
        System.out.println(name + " feeds " + animal.getName());
    }

    @Override
    public String toString() {
        return "Zookeeper{name='" + name + "', experienceYears=" + experienceYears + "}";
    }
}
