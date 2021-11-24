package javabeans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest {

    @Test
    void testCreate() {
        Human human = new Human();
        human.setName("Einstein");
        human.setWeight(75.5);
        human.setIq(250);

        assertEquals("Einstein", human.getName());
        assertEquals(75.5, human.getWeight());
        assertEquals(250, human.getIq());
    }

}