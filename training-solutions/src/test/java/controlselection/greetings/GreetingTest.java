package controlselection.greetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {

    @Test
    void testGreet() {

        Greetings greetings = new Greetings();

        assertEquals("Good night!", greetings.greet(4, 30));
        assertEquals("Good night!", greetings.greet(5, 0));
        assertEquals("Good morning!", greetings.greet(5, 1));
        assertEquals("Good morning!", greetings.greet(9, 0));
        assertEquals("Good day!", greetings.greet(9, 1));
        assertEquals("Good day!", greetings.greet(18, 30));
        assertEquals("Good evening!", greetings.greet(18, 31));
        assertEquals("Good evening!", greetings.greet(20, 0));
        assertEquals("Good night!", greetings.greet(20, 1));
    }

}
