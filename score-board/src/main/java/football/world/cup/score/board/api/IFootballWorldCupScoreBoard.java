package football.world.cup.score.board.api;

import football.world.cup.score.board.model.Game;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public interface IFootballWorldCupScoreBoard {
    void startGame(final String homeTeam, final String awayTeam);

    void finishGame() throws CloneNotSupportedException;

    void updateScore(final Pair<Integer, Integer> score);

    List<Game> getSummaryOfGamesByTotalScore();
}
