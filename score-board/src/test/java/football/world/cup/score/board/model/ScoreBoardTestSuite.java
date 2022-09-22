package football.world.cup.score.board.model;

import football.world.cup.score.board.TestSuiteBasic;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ScoreBoardTestSuite extends TestSuiteBasic {
    private final String homeTeam;
    private final String awayTeam;

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {"Mexico", "Canada"}
        });
    }

    public ScoreBoardTestSuite(final String homeTeam, final String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Test
    public void testStartCurrentGame() {
        //Given
        final ScoreBoard scoreBoard = new ScoreBoard();

        //When
        scoreBoard.startCurrentGame(homeTeam, awayTeam);
        scoreBoard.startCurrentGame(awayTeam, homeTeam);

        //Then
        Assert.assertEquals(scoreBoard.getCurrentGame(), scoreBoard.getCurrentGame());
        Assert.assertEquals(homeTeam, scoreBoard.getCurrentGame().getHomeTeam().getCountry());
        Assert.assertEquals(awayTeam, scoreBoard.getCurrentGame().getAwayTeam().getCountry());
    }
}
