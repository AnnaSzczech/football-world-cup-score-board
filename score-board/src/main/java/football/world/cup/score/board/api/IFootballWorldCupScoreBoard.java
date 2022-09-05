package football.world.cup.score.board.api;

import football.world.cup.score.board.model.ScoreBoard;

import java.util.List;

public interface IFootballWorldCupScoreBoard {
    void startGame(final String homeTeam, final String awayTeam);
    void finishGame();
    void updateScore(final String score);
    List<ScoreBoard> getSummaryOfGamesByTotalScore();
}
