package football.world.cup.score.board.api;

import football.world.cup.score.board.TestSuiteBasic;
import football.world.cup.score.board.model.ScoreBoard;
import org.junit.Assert;
import org.junit.Test;

public class FootballWorldCupScoreBoardTestSuite  extends TestSuiteBasic {

    @Test
    public void testStartGame() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();
        IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

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
        IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

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
        IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

        //When
        footballWorldCupScoreBoard.startGame("Mexico ", " Canada ");
        footballWorldCupScoreBoard.updateScore("Mexico - Canada: 0 - 5");

        //Then
        Assert.assertTrue(scoreBoard.isGameContinues());
    }

    @Test
    public void testGetSummaryOfGamesByTotalScore() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();
        IFootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

        //When
        int summaryOfGamesScoreSize = footballWorldCupScoreBoard.getSummaryOfGamesByTotalScore().size();

        //Then
//        Assert.assertEquals(1, summaryOfGamesScoreSize);
    }
}
