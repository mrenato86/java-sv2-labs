package composition.person;

public class PersonMain {

    public static void main(String[] args) {
        Person person = new Person("John Doe", "AB12345");
        Address address = new Address("Hungary", "Budapest", "X street 6.", "1234");

        person.moveTo(address);
        System.out.println(person.personToString());
        System.out.println(person.getAddress().addressToString());
        System.out.println();

        person.correctData("Jack Doe", "BA54321");
        System.out.println(person.personToString());
        person.getAddress().correctData("Hungary", "Budapest", "Y street 31", "4321");
        System.out.println(person.getAddress().addressToString());

        Address newAddress = new Address("USA", "New York", "Times square", "56789");
        person.moveTo(newAddress);

        System.out.println(person.getAddress().addressToString());
    }

}
