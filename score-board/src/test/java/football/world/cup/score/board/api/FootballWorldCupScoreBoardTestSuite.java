package football.world.cup.score.board.api;

import football.world.cup.score.board.TestSuiteBasic;
import football.world.cup.score.board.model.Game;
import football.world.cup.score.board.model.ScoreBoard;
import football.world.cup.score.board.service.BoardService;
import football.world.cup.score.board.service.ScoreComparator;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FootballWorldCupScoreBoardTestSuite extends TestSuiteBasic {

    @Test
    public void testStartGame() {
        //Given
        final BoardService boardService = new BoardService(new ArrayList<>());
        final IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(boardService);

        //When
        footballWorldCupScoreBoard.startGame("Mexico ", " Canada ");
        ScoreBoard scoreBoard = boardService.getScoreBoard();

        //Then
        Assert.assertTrue(scoreBoard.isBoardSet());
        Assert.assertEquals("Mexico", scoreBoard.getCurrentGame().getHomeTeam().getCountry());
        Assert.assertEquals("Canada", scoreBoard.getCurrentGame().getAwayTeam().getCountry());
        Assert.assertEquals(0, scoreBoard.getCurrentGame().getHomeTeam().getScore());
        Assert.assertEquals(0, scoreBoard.getCurrentGame().getAwayTeam().getScore());
        Assert.assertEquals(1, boardService.getScoreBoards(new ScoreComparator()).size());
    }

    @Test
    public void testStartGameWithIncorrectCountry() {
        //Given
        final BoardService boardService = new BoardService(new ArrayList<>());
        final IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(boardService);

        //When
        footballWorldCupScoreBoard.startGame("Mexico ", " Test ");

        //Then
        Assert.assertNull(boardService.getScoreBoard());
    }

    @Test
    public void testFinishGame() throws CloneNotSupportedException {
        //Given
        final BoardService boardService = new BoardService(new ArrayList<>());
        final IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(boardService);

        //When
        footballWorldCupScoreBoard.startGame("Mexico ", " Canada ");
        footballWorldCupScoreBoard.finishGame();

        //Then
        Assert.assertNull(boardService.getScoreBoard());
    }

    @Test
    public void testUpdateScore() {
        //Given
        final BoardService boardService = new BoardService(new ArrayList<>());
        final IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(boardService);

        //When
        footballWorldCupScoreBoard.startGame("Mexico ", " Canada ");
        footballWorldCupScoreBoard.updateScore(Pair.of(4, 3));
        ScoreBoard scoreBoard = boardService.getScoreBoard();

        //Then
        Assert.assertTrue(scoreBoard.isBoardSet());
        Assert.assertEquals("Mexico", scoreBoard.getCurrentGame().getHomeTeam().getCountry());
        Assert.assertEquals("Canada", scoreBoard.getCurrentGame().getAwayTeam().getCountry());
        Assert.assertEquals(4, scoreBoard.getCurrentGame().getHomeTeam().getScore());
        Assert.assertEquals(3, scoreBoard.getCurrentGame().getAwayTeam().getScore());
        Assert.assertEquals(1, boardService.getScoreBoards(new ScoreComparator()).size());
        Assert.assertEquals(4, boardService.getScoreBoards(new ScoreComparator()).get(0).getHomeTeam().getScore());
        Assert.assertEquals(3, boardService.getScoreBoards(new ScoreComparator()).get(0).getAwayTeam().getScore());
    }

    @Test
    public void testGetSummaryOfGamesByTotalScore() throws CloneNotSupportedException {
        //Given
        final BoardService boardService = new BoardService(createSummaryOfGames());
        final IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(boardService);

        //When
        footballWorldCupScoreBoard.startGame("Argentina ", " Australia ");
        footballWorldCupScoreBoard.updateScore(Pair.of(1, 0));
        footballWorldCupScoreBoard.updateScore(Pair.of(3, 1));
        List<Game> games = boardService.getScoreBoards(new ScoreComparator());

        //Then
        games.forEach(System.out::println);
        Assert.assertEquals(5, games.size());
    }

    private List<Game> createSummaryOfGames(){
        List<Game> games = new ArrayList<>();
        games.add(createGame("Mexico","Canada",0,5));
        games.add(createGame("Spain","Brazil:",10,2));
        games.add(createGame("Germany","France",2,2));
        games.add(createGame("Uruguay","Italy",6,6));
        return games;
    }

    private Game createGame(final String homeTeam, final String awayTeam, final int homeTeamScore, final int awayTeamScore) {
        final Game game = new Game(homeTeam, awayTeam);
        game.getHomeTeam().setScore(homeTeamScore);
        game.getAwayTeam().setScore(awayTeamScore);
        return game;
    }
}
