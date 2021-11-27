package defaultconstructor.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TeamTest {

    @Test
    void testCreate() {
        Team team = new Team();

        assertNull(team.getPlayerOne());
        assertNull(team.getPlayerTwo());
    }

    @Test
    void testSetPlayers() {
        Player playerOne = new Player();
        playerOne.setName("John Doe");
        playerOne.setEmail("johnDoe@gmail.com");

        Player playerTwo = new Player();
        playerTwo.setName("Jane Doe");
        playerTwo.setEmail("janeD@gmail.com");

        Team team = new Team();
        team.setPlayerOne(playerOne);
        team.setPlayerTwo(playerTwo);

        assertEquals("John Doe", team.getPlayerOne().getName());
        assertEquals("janeD@gmail.com", team.getPlayerTwo().getEmail());
    }

}