package football.world.cup.score.board.api;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FootballWorldCupScoreBoardTestSuite {
    private static final Logger LOG = LoggerFactory.getLogger(FootballWorldCupScoreBoardTestSuite.class);
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
    public void testStartGame() {
        //Given
        FootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard();

        //When
        footballWorldCupScoreBoard.startGame("Mexico", "Canada");

        //Then
        Assert.assertTrue(footballWorldCupScoreBoard.isGameContinues());
    }

    @Test
    public void testFinishGame() {
        //Given
        FootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard();

        //When
        footballWorldCupScoreBoard.finishGame();

        //Then
        Assert.assertFalse(footballWorldCupScoreBoard.isGameContinues());
    }

    @Test
    public void testUpdateScore() {
        //Given
        FootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard();

        //When
        footballWorldCupScoreBoard.updateScore("Mexico - Canada: 0 - 5");

        //Then
        Assert.assertTrue(footballWorldCupScoreBoard.isGameContinues());
    }

    @Test
    public void testGetSummaryOfGamesByTotalScore() {
        //Given
        FootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard();

        //When
        int summaryOfGamesScoreSize = footballWorldCupScoreBoard.getSummaryOfGamesByTotalScore().size();

        //Then
        Assert.assertEquals(1, summaryOfGamesScoreSize);
    }
}
