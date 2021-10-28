package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {
        Person person1;
        Person person2;

        person1 = new Person("John Doe", 25);
        person2 = person1;
        person2.setName("Jane Moe");

        System.out.println(person1.getName() + " " + person1.getAge());
        System.out.println(person2.getName() + " " + person2.getAge());
        //Same reference, both changed

        int num1 = 24;
        int num2 = num1;
        num2++;
        System.out.println(num1 + " " + num2);
        //Copy of value were assigned, no change in original

        person2 = new Person("Jack Doe", 32);
        System.out.println(person1.getName() + " " + person1.getAge());
        System.out.println(person2.getName() + " " + person2.getAge());
        //Reference changed, different object created

    }

}
