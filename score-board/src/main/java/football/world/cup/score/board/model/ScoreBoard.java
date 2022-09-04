package football.world.cup.score.board.model;

public class ScoreBoard {
    private String homeTeam;
    private int homeTeamScore;
    private String awayTeam;
    private int awayTeamScore;

    public void setBoard(final String homeTeam, final String awayTeam) {
        // do nothing
    }

    public void resetBoard() {
        // do nothing
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(final int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(final int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    private void setHomeTeam(final String homeTeam) {
        this.homeTeam = homeTeam;
    }

    private void setAwayTeam(final String awayTeam) {
        this.awayTeam = awayTeam;
    }
}
