package football.world.cup.score.board.api;

import football.world.cup.score.board.model.ScoreBoard;

import java.util.List;

public interface IFootballWorldCupScoreBoard {
    boolean startGame(final String homeTeam, final String awayTeam);

    boolean finishGame() throws CloneNotSupportedException;

    boolean updateScore(final String score);

    List<ScoreBoard> getSummaryOfGamesByTotalScore();
}
