package football.world.cup.score.board;

import football.world.cup.score.board.api.FootballWorldCupScoreBoard;
import football.world.cup.score.board.api.IFootballWorldCupScoreBoard;
import football.world.cup.score.board.model.GamesSummary;
import football.world.cup.score.board.model.ScoreBoard;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SimulationTestSuite extends TestSuiteBasic {
    @Test
    public void testGetSummaryOfGamesByTotalScore() throws CloneNotSupportedException {
        //Given
        GamesSummary gamesSummary = new GamesSummary();
        final IFootballWorldCupScoreBoard scoreBoardOne = new FootballWorldCupScoreBoard(gamesSummary, new ScoreBoard());
        final IFootballWorldCupScoreBoard scoreBoardSecond = new FootballWorldCupScoreBoard(gamesSummary, new ScoreBoard());
        final IFootballWorldCupScoreBoard scoreBoardThird = new FootballWorldCupScoreBoard(gamesSummary, new ScoreBoard());

        //When
        scoreBoardOne.startGame("Mexico ", " Canada ");
        scoreBoardSecond.startGame("Spain ", " Brazil ");
        scoreBoardThird.startGame("Germany ", " France ");

        scoreBoardSecond.updateScore("Spain - Brazil: 1 - 0");
        scoreBoardSecond.updateScore("Spain - Brazil: 1 - 1");
        scoreBoardOne.updateScore("Mexico - Canada: 0 - 1");
        scoreBoardSecond.updateScore("Spain - Brazil: 1 - 2");
        scoreBoardSecond.finishGame();
        scoreBoardOne.updateScore("Mexico - Canada: 1 - 1");
        scoreBoardThird.updateScore("Germany - France: 1 - 0");
        scoreBoardThird.finishGame();
        scoreBoardOne.finishGame();

        System.out.println("-------------------------");
        final List<ScoreBoard> summaryOfGamesOne = scoreBoardOne.getSummaryOfGamesByTotalScore();
        System.out.println("-------------------------");
        final List<ScoreBoard> summaryOfGamesSecond = scoreBoardSecond.getSummaryOfGamesByTotalScore();
        System.out.println("-------------------------");
        final List<ScoreBoard> summaryOfGamesThird = scoreBoardThird.getSummaryOfGamesByTotalScore();
        System.out.println("-------------------------");
        List<ScoreBoard> result = createScoreBoardList("Mexico", 1, "Canada", 1);
        result.addAll(createScoreBoardList("Germany", 1, "France", 0));
        result.addAll(createScoreBoardList("Spain", 1, "Brazil", 2));

        //Then
        Assert.assertEquals(3, summaryOfGamesOne.size());
        Assert.assertEquals(3, summaryOfGamesSecond.size());
        Assert.assertEquals(3, summaryOfGamesThird.size());

        Assert.assertEquals(result, summaryOfGamesOne);
        Assert.assertEquals(result, summaryOfGamesSecond);
        Assert.assertEquals(result, summaryOfGamesThird);

        Assert.assertEquals(summaryOfGamesOne, summaryOfGamesSecond);
        Assert.assertEquals(summaryOfGamesSecond, summaryOfGamesThird);
        Assert.assertEquals(summaryOfGamesOne, summaryOfGamesThird);
    }
}
