package football.world.cup.score.board.utils;

import football.world.cup.score.board.TestSuiteBasic;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CountryUtilsTestSuite extends TestSuiteBasic {
    private final String homeTeam;
    private final String awayTeam;
    private final boolean validateCountry;
    private final boolean validateTeams;

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {"Mexico", "Canada", true, true},//
                {"Test", "Test", false, false},//
                {"Mexico 2", "Canada", false, true}//
        });
    }

    public CountryUtilsTestSuite(final String homeTeam, final String awayTeam, final boolean validateCountry, final boolean validateTeams) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.validateCountry = validateCountry;
        this.validateTeams = validateTeams;
    }

    @Test
    public void testIsCountryNameCorrect() {
        //Given

        //When
        final boolean isCountryNameCorrect = CountryUtils.isCountryNameCorrect(homeTeam);

        //Then
        Assert.assertEquals(isCountryNameCorrect, validateCountry);
    }

    @Test
    public void testDifferentTeam() {
        //Given

        //When
        final boolean isTeamNameDifferent = CountryUtils.differentTeam(homeTeam, awayTeam);

        //Then
        Assert.assertEquals(isTeamNameDifferent, validateTeams);
    }
}
