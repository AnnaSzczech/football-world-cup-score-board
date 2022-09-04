package football.world.cup.score.board.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FootballWorldCupScoreBoard implements IFootballWorldCupScoreBoard {

    private boolean isGameContinues;
    private static final Logger LOG = LoggerFactory.getLogger(FootballWorldCupScoreBoard.class);

    @Override
    public void startGame(String homeTeam, String awayTeam) {
        this.isGameContinues = true;
    }

    @Override
    public void finishGame() {
        this.isGameContinues = false;
    }

    @Override
    public void updateScore(String score) {
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
