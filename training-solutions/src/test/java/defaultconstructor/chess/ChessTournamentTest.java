package defaultconstructor.chess;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ChessTournamentTest {

    @Test
    void testCreate() {
        ChessTournament chessTournament = new ChessTournament();
        assertEquals(3, chessTournament.getTeams().size());
    }

    @Test
    void testAddPlayersToTeamsMorePlayers() {
        ChessTournament chessTournament = new ChessTournament();

        List<Player> testPlayersList = new ArrayList<>();
        for (char c = 'A'; c <= 'G'; c++) {
            Player player = new Player();
            player.setName("Player " + c);
            player.setEmail(c + "@gmail.com");
            testPlayersList.add(player);
        }

        chessTournament.addPlayersToTeams(testPlayersList);

        assertEquals("Player D", chessTournament.getTeams().get(1).getPlayerTwo().getName());
        assertEquals("E@gmail.com", chessTournament.getTeams().get(2).getPlayerOne().getEmail());
    }

    @Test
    void testAddPlayersToTeamsFewerPlayers() {
        ChessTournament chessTournament = new ChessTournament();

        List<Player> testPlayersList = new ArrayList<>();
        for (char c = 'A'; c <= 'C'; c++) {
            Player player = new Player();
            player.setName("Player " + c);
            player.setEmail(c + "@gmail.com");
            testPlayersList.add(player);
        }
        chessTournament.addPlayersToTeams(testPlayersList);

        assertEquals("Player B", chessTournament.getTeams().get(0).getPlayerTwo().getName());
        assertNull(chessTournament.getTeams().get(1).getPlayerTwo());
        assertNull(chessTournament.getTeams().get(2).getPlayerOne());
    }

}