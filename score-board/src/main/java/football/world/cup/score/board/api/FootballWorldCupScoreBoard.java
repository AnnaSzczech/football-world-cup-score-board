package football.world.cup.score.board.api;

import football.world.cup.score.board.model.GamesSummary;
import football.world.cup.score.board.model.ScoreBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static football.world.cup.score.board.utils.ScoreUtils.validateScore;
import static org.apache.commons.lang3.StringUtils.trim;
import static football.world.cup.score.board.utils.CountryUtils.isCountryNameCorrect;
import static football.world.cup.score.board.utils.CountryUtils.differentTeam;

public class FootballWorldCupScoreBoard implements IFootballWorldCupScoreBoard {

    private static final Logger LOG = LoggerFactory.getLogger(FootballWorldCupScoreBoard.class);

    private final GamesSummary gamesSummary;
    private final ScoreBoard scoreBoard;

    public FootballWorldCupScoreBoard(final GamesSummary gamesSummary, final ScoreBoard scoreBoard) {
        this.gamesSummary = gamesSummary;
        this.scoreBoard = scoreBoard;
    }

    @Override
    public void startGame(final String homeTeam, final String awayTeam) {
        if (!scoreBoard.isGameContinues() && validateCountry(homeTeam, awayTeam)) {
            scoreBoard.setBoard(trim(homeTeam), trim(awayTeam));
        } else {
            LOG.error("Game has not been started!");
        }
    }

    @Override
    public void finishGame() throws CloneNotSupportedException {
        if (scoreBoard.isGameContinues()) {
            gamesSummary.addScoreToSummary(scoreBoard);
            scoreBoard.resetBoard();
        } else {
            LOG.error("Game has not been finished!");
        }
    }

    @Override
    public void updateScore(final String scoreText) {
        final Optional<Map<String, Integer>> score = validateScore(scoreText, scoreBoard.getHomeTeam(), scoreBoard.getAwayTeam());
        if (scoreBoard.isGameContinues() && score.isPresent()) {
            scoreBoard.setHomeTeamScore(score.get().get(scoreBoard.getHomeTeam()));
            scoreBoard.setAwayTeamScore(score.get().get(scoreBoard.getAwayTeam()));
        } else {
            LOG.error("Score has not been updated!");
        }
    }

    @Override
    public List<ScoreBoard> getSummaryOfGamesByTotalScore() {
        gamesSummary.getScoreBoards().forEach(score -> LOG.info(score.toString()));
        return gamesSummary.getScoreBoards();
    }

    private boolean validateCountry(final String oneTeam, final String secondTeam) {
        final String homeTeam = trim(oneTeam);
        final String awayTeam = trim(secondTeam);
        return isCountryNameCorrect(homeTeam) && isCountryNameCorrect(awayTeam) && differentTeam(homeTeam, awayTeam);
    }
}
