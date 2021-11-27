package defaultconstructor.chess;

import java.util.Arrays;
import java.util.List;

public class ChessTournament {

    private List<Team> teams;

    public ChessTournament() {
        this.teams = Arrays.asList(new Team(), new Team(), new Team());
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addPlayersToTeams(List<Player> playersRegistered) {
        for (int i = 0; i < teams.size() * 2 && i < playersRegistered.size(); i++) {
            setPlayerToTeam(i, playersRegistered.get(i));
        }
    }

    private void setPlayerToTeam(int cumulativeTeamIndex, Player player) {
        if (cumulativeTeamIndex % 2 == 0) {
            teams.get(cumulativeTeamIndex / 2).setPlayerOne(player);
        } else {
            teams.get(cumulativeTeamIndex / 2).setPlayerTwo(player);
        }
    }
}
