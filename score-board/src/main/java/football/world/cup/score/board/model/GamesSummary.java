package football.world.cup.score.board.model;

import java.util.LinkedList;
import java.util.List;

public class GamesSummary {
    private final List<ScoreBoard> scoreBoards = new LinkedList<>();

    public boolean addScoreToSummary(final ScoreBoard scoreBoard) {
        return scoreBoards.add(scoreBoard);
    }

    public List<ScoreBoard> getScoreBoards() {
        return scoreBoards;
    }
}
