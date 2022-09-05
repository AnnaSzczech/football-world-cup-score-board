package football.world.cup.score.board;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
