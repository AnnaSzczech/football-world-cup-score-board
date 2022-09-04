package football.world.cup.score.board.api;

import football.world.cup.score.board.model.ScoreBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;

public class FootballWorldCupScoreBoard implements IFootballWorldCupScoreBoard {

    private static final Logger LOG = LoggerFactory.getLogger(FootballWorldCupScoreBoard.class);

    private boolean isGameContinues;
    private final ScoreBoard scoreBoard;

    public FootballWorldCupScoreBoard(final ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        this.isGameContinues = false;
    }

    @Override
    public void startGame(final String homeTeam, final String awayTeam) {
        if (!isGameContinues) {
            scoreBoard.setBoard(trim(homeTeam), trim(awayTeam));
            this.isGameContinues = true;
        } else {
            LOG.error("Game has not been started!");
        }
    }

    @Override
    public void finishGame() {
        if (isGameContinues) {
            scoreBoard.resetBoard();
            this.isGameContinues = false;
        } else {
            LOG.error("Game has not been finished!");
        }
    }

    @Override
    public void updateScore(final String score) {
        // do nothing
    }

    @Override
    public List<String> getSummaryOfGamesByTotalScore() {
        return new ArrayList<>();
    }

    public boolean isGameContinues() {
        return isGameContinues;
    }
}
