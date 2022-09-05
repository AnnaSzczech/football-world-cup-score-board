package football.world.cup.score.board.model;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScoreBoardTestSuite {
    private static final Logger LOG = LoggerFactory.getLogger(ScoreBoardTestSuite.class);
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        LOG.debug("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        LOG.debug("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        LOG.debug("Preparing to execute test #" + testCounter);
    }

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
