package collectionsqueue;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Vaccination {

    public Queue<Integer> getVaccinationOrder(List<Person> people) {
        Queue<Integer> order = new PriorityQueue<>();
        for (Person person : people) {
            int age = person.getAge();
            if (age >= 18 && age <= 65) {
                order.add(age);
            }
        }
        return order;
    }

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Kiss József", 76),
                new Person("Nagy Béla", 24),
                new Person("Szép Virág", 65),
                new Person("Pál Tamás", 12),
                new Person("Németh Gergely", 83),
                new Person("Szabó Fruzsina", 54)
        );
        Vaccination vaccination = new Vaccination();
        Queue<Integer> vaccinationOrder = vaccination.getVaccinationOrder(people);

        System.out.println(vaccinationOrder);
        System.out.println(vaccinationOrder.poll());
        System.out.println(vaccinationOrder.poll());
        System.out.println(vaccinationOrder.poll());
        System.out.println(vaccinationOrder.isEmpty());
    }
}
