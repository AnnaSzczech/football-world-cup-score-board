package football.world.cup.score.board.service;

import football.world.cup.score.board.model.Game;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Game> {
    @Override
    public int compare(Game o1, Game o2) {
        return (getTotalScores(o1) > getTotalScores(o2)) ? -1 : ((getTotalScores(o1) == getTotalScores(o2)) ? -1 : 0);
    }

    private int getTotalScores(Game game) {
        return game.getHomeTeam().getScore() + game.getAwayTeam().getScore();
    }
}
