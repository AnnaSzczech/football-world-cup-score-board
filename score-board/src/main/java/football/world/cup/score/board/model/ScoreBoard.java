package football.world.cup.score.board.model;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ScoreBoard {

    private static final Logger LOG = LoggerFactory.getLogger(ScoreBoard.class);
    private Game currentGame;

    public Game startCurrentGame(final String homeTeam, final String awayTeam) {
        if (StringUtils.isBlank(homeTeam) || StringUtils.isBlank(awayTeam)) {
            return null;
        }
        if (currentGame == null) {
            LOG.info("New ScoreBoard created!");
            currentGame = new Game(homeTeam, awayTeam);
        }
        return currentGame;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void resetBoard() {
        LOG.info("Match removed from the scoreboard!");
        currentGame = null;
    }

    public boolean isBoardSet () {
        return currentGame != null;
    }
}



