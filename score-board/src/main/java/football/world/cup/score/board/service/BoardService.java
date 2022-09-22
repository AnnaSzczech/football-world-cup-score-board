package football.world.cup.score.board.service;

import football.world.cup.score.board.model.Game;
import football.world.cup.score.board.model.ScoreBoard;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Completable;

import java.util.Comparator;
import java.util.List;

import static football.world.cup.score.board.utils.CountryUtils.validateCountry;
import static java.util.stream.Collectors.toList;

public final class BoardService {

    private static final Logger LOG = LoggerFactory.getLogger(BoardService.class);
    private final List<Game> games;
    private ScoreBoard scoreBoard;

    public BoardService(List<Game> games) {
        this.games = games;
    }

    public void validateNewGame(final String homeTeam, final String awayTeam) {
        if (scoreBoard != null || !validateCountry(homeTeam, awayTeam)) {
            throw new RuntimeException("Game already set or data isn't correct!");
        }
    }

    public void validateFinishGame() {
        if (scoreBoard == null  || !scoreBoard.isBoardSet()) {
            throw new RuntimeException("Game has not been set!");
        }
    }

    public void validateScore(Pair<Integer, Integer> score) {
        if (scoreBoard == null || !scoreBoard.isBoardSet() || score == null || validateSingleScore(score.getLeft()) || validateSingleScore(score.getRight())) {
            throw new RuntimeException("Invalid score or game has not been set!");
        }
    }

    private boolean validateSingleScore(Integer singleScore) {
        return singleScore < 0 || singleScore >= 50;
    }

    public void validateGetScoreBoards() {
        if (games.isEmpty()) {
            throw new RuntimeException("ScoreBoards is empty!");
        }
    }

    public void addNewGame(final String homeTeam, final String awayTeam) {
        Completable.fromAction(() -> scoreBoard = new ScoreBoard())
                .subscribe(
                        () -> scoreBoard.startCurrentGame(homeTeam, awayTeam),
                        e -> LOG.error(e.getMessage())
                );
        games.add(scoreBoard.getCurrentGame());
    }

    public void finishGame() {
        Completable.fromAction(() -> scoreBoard = null)
                .subscribe(
                        () -> scoreBoard.resetBoard(),
                        e -> LOG.error(e.getMessage())
                );
    }

    public void updateBoard(Pair<Integer, Integer> score) {
        Completable.fromAction(() -> scoreBoard.isBoardSet())
                .subscribe(
                        () -> {
                            scoreBoard.getCurrentGame().getHomeTeam().setScore(score.getLeft());
                            scoreBoard.getCurrentGame().getAwayTeam().setScore(score.getRight());
                        },
                        e -> LOG.error(e.getMessage())
                );
    }

    public List<Game> getScoreBoards(Comparator<Game> comparator) {
        return  games.stream()
                .sorted(comparator)
                .collect(toList());
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
}