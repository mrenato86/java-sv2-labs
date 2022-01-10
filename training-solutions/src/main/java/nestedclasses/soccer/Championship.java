package nestedclasses.soccer;

import java.util.ArrayList;
import java.util.List;

public class Championship {

    public static class GameResult {
        private final String teamHome;
        private final String teamGuest;
        private final int goalHome;
        private final int goalGuest;

        public GameResult(String teamHome, String teamGuest, int goalHome, int goalGuest) {
            this.teamHome = teamHome;
            this.teamGuest = teamGuest;
            this.goalHome = goalHome;
            this.goalGuest = goalGuest;
        }
    }

    private final List<TeamStatistics> leagueTable = new ArrayList<>();

    public List<TeamStatistics> getLeagueTable() {
        return new ArrayList<>(leagueTable);
    }

    public void addGame(GameResult result) {
        getOrAddTeam(result.teamHome).played(result.goalHome, result.goalGuest);
        getOrAddTeam(result.teamGuest).played(result.goalGuest, result.goalHome);
    }

    private TeamStatistics getOrAddTeam(String teamName) {
        TeamStatistics team = new TeamStatistics(teamName);
        int index = leagueTable.indexOf(team);
        if (index < 0) {
            leagueTable.add(team);
            return team;
        }
        return leagueTable.get(index);
    }
}
