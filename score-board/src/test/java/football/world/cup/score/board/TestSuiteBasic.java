package football.world.cup.score.board;

import football.world.cup.score.board.model.ScoreBoard;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public abstract class TestSuiteBasic {

    private static final Logger LOG = LoggerFactory.getLogger(TestSuiteBasic.class);
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

    protected List<ScoreBoard> createScoreBoardList(final String homeTeam, final int homeTeamScore, final String awayTeam, final int awayTeamScore) {
        final List<ScoreBoard> scoreBoards = new LinkedList<>();
        final ScoreBoard scoreBoard = new ScoreBoard(homeTeam, homeTeamScore, awayTeam, awayTeamScore);
        scoreBoards.add(scoreBoard);
        return scoreBoards;
    }
}
