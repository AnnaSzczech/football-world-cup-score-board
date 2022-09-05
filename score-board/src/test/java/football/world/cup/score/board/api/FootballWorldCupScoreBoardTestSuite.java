package football.world.cup.score.board.api;

import football.world.cup.score.board.TestSuiteBasic;
import football.world.cup.score.board.model.ScoreBoard;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class FootballWorldCupScoreBoardTestSuite extends TestSuiteBasic {

    @Test
    public void testStartGame() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();
        final IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

        //When
        footballWorldCupScoreBoard.startGame("Mexico ", " Canada ");

        //Then
        Assert.assertTrue(scoreBoard.isGameContinues());
        Assert.assertEquals("Mexico", scoreBoard.getHomeTeam());
        Assert.assertEquals("Canada", scoreBoard.getAwayTeam());
        Assert.assertEquals(0, scoreBoard.getHomeTeamScore());
        Assert.assertEquals(0, scoreBoard.getAwayTeamScore());
    }

    @Test
    public void testFinishGame() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();
        final IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

        //When
        footballWorldCupScoreBoard.startGame("Mexico ", " Canada ");
        footballWorldCupScoreBoard.finishGame();

        //Then
        Assert.assertFalse(scoreBoard.isGameContinues());
        Assert.assertNull(scoreBoard.getHomeTeam());
        Assert.assertNull(scoreBoard.getAwayTeam());
    }

    @Test
    public void testUpdateScore() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();
        final IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

        //When
        footballWorldCupScoreBoard.startGame("Mexico ", " Canada ");
        footballWorldCupScoreBoard.updateScore("Mexico - Canada: 2 - 5");

        //Then
        Assert.assertTrue(scoreBoard.isGameContinues());
        Assert.assertEquals(2, scoreBoard.getHomeTeamScore());
        Assert.assertEquals(5, scoreBoard.getAwayTeamScore());
    }

    @Test
    public void testGetSummaryOfGamesByTotalScore() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();
        final IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

        //When
        footballWorldCupScoreBoard.startGame("Mexico ", " Canada ");
        footballWorldCupScoreBoard.updateScore("Mexico - Canada: 1 - 0");
        footballWorldCupScoreBoard.finishGame();
        final List<ScoreBoard> summaryOfGames = footballWorldCupScoreBoard.getSummaryOfGamesByTotalScore();

        //Then
        Assert.assertEquals(1, summaryOfGames.size());
        Assert.assertEquals(createScoreBoardList(), summaryOfGames);
    }

    private List<ScoreBoard> createScoreBoardList() {
        final List<ScoreBoard> scoreBoards = new LinkedList<>();
        final ScoreBoard scoreBoard = new ScoreBoard("Mexico", 1, "Canada", 0);
        scoreBoards.add(scoreBoard);
        return scoreBoards;
    }
}
