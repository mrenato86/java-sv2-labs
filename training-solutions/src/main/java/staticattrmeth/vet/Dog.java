package staticattrmeth.vet;

public class Dog {

    private String name;
    private int age;
    private Species breed;
    private long code;

    public Dog(String name, int age, Species breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Species getBreed() {
        return breed;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }
}
