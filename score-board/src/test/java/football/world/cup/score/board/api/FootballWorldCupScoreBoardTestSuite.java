package football.world.cup.score.board.api;

import football.world.cup.score.board.model.ScoreBoard;
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
        final ScoreBoard scoreBoard = new ScoreBoard();
        FootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

        //When
        footballWorldCupScoreBoard.startGame("Mexico ", " Canada ");

        //Then
        Assert.assertTrue(footballWorldCupScoreBoard.isGameContinues());
        Assert.assertEquals("Mexico", scoreBoard.getHomeTeam());
        Assert.assertEquals("Canada", scoreBoard.getAwayTeam());
        Assert.assertEquals(0, scoreBoard.getHomeTeamScore());
        Assert.assertEquals(0, scoreBoard.getAwayTeamScore());
    }

    @Test
    public void testFinishGame() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();
        FootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

        //When
        footballWorldCupScoreBoard.startGame("Mexico ", " Canada ");
        footballWorldCupScoreBoard.finishGame();

        //Then
        Assert.assertFalse(footballWorldCupScoreBoard.isGameContinues());
        Assert.assertNull(scoreBoard.getHomeTeam());
        Assert.assertNull(scoreBoard.getAwayTeam());
    }

    @Test
    public void testUpdateScore() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();
        FootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

        //When
        footballWorldCupScoreBoard.startGame("Mexico", "Canada");
        footballWorldCupScoreBoard.updateScore("Mexico - Canada: 0 - 5");

        //Then
        Assert.assertTrue(footballWorldCupScoreBoard.isGameContinues());
    }

    @Test
    public void testGetSummaryOfGamesByTotalScore() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();
        FootballWorldCupScoreBoard footballWorldCupScoreBoard = new FootballWorldCupScoreBoard(scoreBoard);

        //When
        int summaryOfGamesScoreSize = footballWorldCupScoreBoard.getSummaryOfGamesByTotalScore().size();

        //Then
//        Assert.assertEquals(1, summaryOfGamesScoreSize);
    }
}
