package junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GentlemanTest {

    @Test
    void testSayHello() {
        //Given
        Gentleman gentleman = new Gentleman();
        String name = "John Doe";
        //When
        String greeting = gentleman.sayHello(name);
        //Then
        assertEquals("Hello John Doe", greeting);
    }

    @Test
    void testSayHelloNull() {
        //Given
        Gentleman gentleman = new Gentleman();
        //When
        String greeting = gentleman.sayHello(null);
        //Then
        assertEquals("Hello Anonymous", greeting);
    }

}
