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
        Assert.assertNotNull(scoreBoard.getHomeTeam());
        Assert.assertNotNull(scoreBoard.getAwayTeam());
    }

    @Test
    public void testResetBoard() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();

        //When
        scoreBoard.resetBoard();

        //Then
        Assert.assertNull(scoreBoard.getHomeTeam());
        Assert.assertNull(scoreBoard.getAwayTeam());
    }
}
