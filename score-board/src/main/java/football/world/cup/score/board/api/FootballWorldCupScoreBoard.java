package football.world.cup.score.board.api;

import football.world.cup.score.board.model.Game;
import football.world.cup.score.board.service.BoardService;
import football.world.cup.score.board.service.ScoreComparator;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Completable;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;

public final class FootballWorldCupScoreBoard implements IFootballWorldCupScoreBoard {

    private static final Logger LOG = LoggerFactory.getLogger(FootballWorldCupScoreBoard.class);
    private final BoardService boardService;

    public FootballWorldCupScoreBoard(final BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    public void startGame(final String homeTeam, final String awayTeam) {
        Completable.fromAction(() -> boardService.validateNewGame(trim(homeTeam), trim(awayTeam)))
                .subscribe(
                        () -> boardService.addNewGame(trim(homeTeam), trim(awayTeam)),
                        e -> LOG.error(e.getMessage())
                );
    }

    @Override
    public void finishGame() {
        Completable.fromAction(boardService::validateFinishGame)
                .subscribe(
                        boardService::finishGame,
                        e -> LOG.error(e.getMessage())
                );
    }

    @Override
    public void updateScore(final Pair<Integer, Integer> score) {
        Completable.fromAction(() -> boardService.validateScore(score))
                .subscribe(
                        () -> boardService.updateBoard(score),
                        e -> LOG.error(e.getMessage())
                );
    }

    @Override
    public List<Game> getSummaryOfGamesByTotalScore() {
        final List[] holder = new List[]{new ArrayList<>()};

        Completable.fromAction(boardService::validateGetScoreBoards)
                .subscribe(
                        () -> holder[0] = boardService.getScoreBoards(new ScoreComparator()),
                        e -> LOG.error(e.getMessage())
                );
        return holder[0];
    }
}
