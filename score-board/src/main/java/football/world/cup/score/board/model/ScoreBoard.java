package football.world.cup.score.board.model;

public class ScoreBoard {
    private String homeTeam;
    private int homeTeamScore;
    private String awayTeam;
    private int awayTeamScore;
    private boolean isGameContinues;

    public void setBoard(final String homeTeam, final String awayTeam) {
        setHomeTeam(homeTeam);
        setAwayTeam(awayTeam);
        resetScore();
        this.isGameContinues = true;
    }

    public void resetBoard() {
        this.homeTeam = null;
        this.awayTeam = null;
        resetScore();
        this.isGameContinues = false;
    }

    private void resetScore() {
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
    }
    public boolean isGameContinues() {
        return isGameContinues;
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
