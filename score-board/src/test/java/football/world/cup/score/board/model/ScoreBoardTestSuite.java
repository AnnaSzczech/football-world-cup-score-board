package football.world.cup.score.board.model;

import football.world.cup.score.board.TestSuiteBasic;
import org.junit.Assert;
import org.junit.Test;

public class ScoreBoardTestSuite  extends TestSuiteBasic {

    @Test
    public void testSetBoard() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();

        //When
        scoreBoard.setBoard("Mexico", "Canada");

        //Then
        Assert.assertEquals("Mexico", scoreBoard.getHomeTeam());
        Assert.assertEquals("Canada", scoreBoard.getAwayTeam());
        Assert.assertEquals(0, scoreBoard.getAwayTeamScore());
        Assert.assertEquals(0, scoreBoard.getAwayTeamScore());
    }

    @Test
    public void testIsScoreInCorrectPattern() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();

        //When
        scoreBoard.setBoard("Mexico", "Canada");
        scoreBoard.resetBoard();

        //Then
        Assert.assertNull(scoreBoard.getHomeTeam());
        Assert.assertNull(scoreBoard.getAwayTeam());
    }
}
