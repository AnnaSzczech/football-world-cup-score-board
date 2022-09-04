package football.world.cup.score.board.api;

import java.util.ArrayList;
import java.util.List;

public class FootballWorldCupScoreBoard implements IFootballWorldCupScoreBoard {
    @Override
    public void startGame(String homeTeam, String awayTeam) {
        // do nothing
    }

    @Override
    public void finishGame() {
        // do nothing
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
        return false;
    }
}
