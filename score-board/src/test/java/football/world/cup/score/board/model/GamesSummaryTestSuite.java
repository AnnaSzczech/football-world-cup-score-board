package football.world.cup.score.board.model;

import football.world.cup.score.board.TestSuiteBasic;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GamesSummaryTestSuite extends TestSuiteBasic {
    @Test
    public void testAddScoreToSummary() throws CloneNotSupportedException {
        //Given
        final GamesSummary gamesSummary = new GamesSummary();

        //When
        final boolean isScoreBoardAdded = gamesSummary.addScoreToSummary(new ScoreBoard("Spain", 10, "Brazil", 2));

        //Then
        Assert.assertTrue(isScoreBoardAdded);
    }

    @Test
    public void testGetScoreBoards() throws CloneNotSupportedException {
        //Given
        final GamesSummary gamesSummary = new GamesSummary();

        //When
        final ScoreBoard scoreBoard = new ScoreBoard("Spain", 10, "Brazil", 2);
        gamesSummary.addScoreToSummary(scoreBoard);

        final List<ScoreBoard> summary = gamesSummary.getScoreBoards();
        scoreBoard.setAwayTeamScore(5);
        scoreBoard.setHomeTeamScore(7);

        //Then
        Assert.assertEquals(createScoreBoardList("Spain", 10, "Brazil", 2), summary);
    }
}
