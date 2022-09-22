package football.world.cup.score.board.model;

import java.util.Objects;

public final class Team {
    private final String country;
    private int score;

    public Team(final String country) {
        this.country = country;
        this.score = 0;
    }

    public String getCountry() {
        return country;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return score == team.score &&
                Objects.equals(country, team.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, score);
    }

    @Override
    public String toString() {
        return country + " " + score;
    }
}
