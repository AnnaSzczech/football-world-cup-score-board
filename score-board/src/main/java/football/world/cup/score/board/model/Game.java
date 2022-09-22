package football.world.cup.score.board.model;

import java.util.Objects;

public final class Game {
    private final Team homeTeam;
    private final Team awayTeam;

    public Game(final String homeTeam, final String  awayTeam) {
        this.homeTeam = new Team(homeTeam);
        this.awayTeam = new Team(awayTeam);
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(homeTeam, game.homeTeam) &&
                Objects.equals(awayTeam, game.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }

    @Override
    public String toString() {
        return homeTeam + " - " + awayTeam;
    }
}
