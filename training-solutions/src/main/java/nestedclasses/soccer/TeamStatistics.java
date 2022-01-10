package nestedclasses.soccer;

import java.util.Objects;

public class TeamStatistics {

    private static class Games {
        private int played;
        private int won;
        private int tied;
        private int lost;
    }

    private final String teamName;
    private final Games games;
    private int goalsFor;
    private int goalsAgainst;
    private int points;

    public TeamStatistics(String teamName) {
        this.teamName = teamName;
        this.games = new Games();
    }

    public void played(int plusGoalsFor, int plusGoalsAgainst) {
        if (plusGoalsFor > plusGoalsAgainst) {
            games.won++;
        } else if (plusGoalsFor < plusGoalsAgainst) {
            games.lost++;
        } else {
            games.tied++;
        }
        games.played++;
        goalsFor += plusGoalsFor;
        goalsAgainst += plusGoalsAgainst;
        points = games.won * 3 + games.tied;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPlayed() {
        return games.played;
    }

    public int getWon() {
        return games.won;
    }

    public int getTied() {
        return games.tied;
    }

    public int getLost() {
        return games.lost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamStatistics that = (TeamStatistics) o;
        return Objects.equals(teamName, that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName);
    }
}
