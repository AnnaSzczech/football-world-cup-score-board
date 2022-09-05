package football.world.cup.score.board.model;

import java.util.Objects;

public class ScoreBoard extends ScoreBoardPrototype<ScoreBoard> {
    private String homeTeam;
    private int homeTeamScore;
    private String awayTeam;
    private int awayTeamScore;
    private boolean isGameContinues;

    public ScoreBoard(final String homeTeam, final int homeTeamScore, final String awayTeam, final int awayTeamScore) {
        this.homeTeam = homeTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeam = awayTeam;
        this.awayTeamScore = awayTeamScore;
        this.isGameContinues = false;
    }

    public ScoreBoard() {
        this.isGameContinues = false;
    }

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

    public ScoreBoard shallowCopy() throws CloneNotSupportedException {
        return (ScoreBoard) super.clone();
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

    @Override
    public String toString() {
        return homeTeam + ' ' + homeTeamScore + " - " + awayTeam + ' ' + awayTeamScore + "\\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreBoard that = (ScoreBoard) o;
        return homeTeamScore == that.homeTeamScore &&
                awayTeamScore == that.awayTeamScore &&
                isGameContinues == that.isGameContinues &&
                Objects.equals(homeTeam, that.homeTeam) &&
                Objects.equals(awayTeam, that.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, homeTeamScore, awayTeam, awayTeamScore, isGameContinues);
    }
}
