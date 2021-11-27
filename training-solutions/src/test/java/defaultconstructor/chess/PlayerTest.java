package defaultconstructor.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PlayerTest {

    @Test
    void testCreate() {
        Player player = new Player();

        assertNull(player.getName());
        assertNull(player.getEmail());
    }

    @Test
    void testSet() {
        Player player = new Player();
        player.setName("John Doe");
        player.setEmail("johnD@gmail.com");

        assertEquals("John Doe", player.getName());
        assertEquals("johnD@gmail.com", player.getEmail());
    }

}