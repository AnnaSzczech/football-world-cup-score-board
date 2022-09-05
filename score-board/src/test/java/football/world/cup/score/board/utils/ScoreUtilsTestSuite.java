package football.world.cup.score.board.utils;

import football.world.cup.score.board.TestSuiteBasic;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class ScoreUtilsTestSuite extends TestSuiteBasic {
    private final String scoreText;
    private final String homeTeam;
    private final String awayTeam;
    private final boolean result;
    private final Map<String, Integer> score;

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {"Mexico - Canada: 0 - 5", "Mexico", "Canada", true, createScoreMap(new String[]{"Mexico", "Canada"}, new Integer[]{0, 5})},//
                {"Argentina-Australia:4-1", "Argentina", "Australia", true, createScoreMap(new String[]{"Australia", "Argentina"}, new Integer[]{1, 4})},//
                {"Argentina-Australia 4-1", "Mexico", "Australia", false, Collections.EMPTY_MAP},//
                {"0 - 5", "", "", false, Collections.EMPTY_MAP}//
        });
    }

    public ScoreUtilsTestSuite(final String scoreText, final String homeTeam, final String awayTeam, final boolean result, final Map<String, Integer> score) {
        this.scoreText = scoreText;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.result = result;
        this.score = score;
    }

    @Test
    public void testValidateScore() {
        //Given

        //When
        final Optional<Map<String, Integer>> score = ScoreUtils.validateScore(scoreText, homeTeam, awayTeam);

        //Then
        Assert.assertEquals(!this.score.isEmpty(), score.isPresent());
        score.ifPresent(map -> Assert.assertEquals(this.score, map));
    }

    @Test
    public void testIsScoreInCorrectPattern() {
        //Given

        //When
        final boolean isScoreInCorrectPattern = ScoreUtils.isScoreInCorrectPattern(scoreText);

        //Then
        Assert.assertEquals(result, isScoreInCorrectPattern);
    }

    private static Map<String, Integer> createScoreMap(final String[] teams, final Integer[] scores) {
        final Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put(teams[0], scores[0]);
        scoreMap.put(teams[1], scores[1]);
        return scoreMap;
    }
}
