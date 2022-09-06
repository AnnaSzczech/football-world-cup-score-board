package football.world.cup.score.board.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class GamesSummary {
    private final List<ScoreBoard> scoreBoards = new LinkedList<>();

    public boolean addScoreToSummary(final ScoreBoard scoreBoard) throws CloneNotSupportedException {
        return scoreBoards.add(scoreBoard.shallowCopy());
    }

    public List<ScoreBoard> getScoreBoards() {
        final List<ScoreBoard> scoreBoardsCopy = List.copyOf(scoreBoards);
        Collections.reverse(scoreBoardsCopy);
        return scoreBoardsCopy;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final GamesSummary that = (GamesSummary) o;
        return Objects.equals(scoreBoards, that.scoreBoards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreBoards);
    }
}