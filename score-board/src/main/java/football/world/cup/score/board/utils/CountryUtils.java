package football.world.cup.score.board.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class CountryUtils {
    final private static List<String> countries = Arrays.stream(Locale.getISOCountries())//
            .map(locale -> new Locale("", locale).getDisplayCountry(Locale.ENGLISH).toLowerCase())//
            .collect(toList());

    public static boolean isCountryNameCorrect(final String country) {
        return isNotBlank(country) && countries.contains(country.toLowerCase());
    }

    public static boolean differentTeam(final String homeTeam, final String awayTeam) {
        return isNotBlank(homeTeam) && isNotBlank(awayTeam) && !homeTeam.equalsIgnoreCase(awayTeam);
    }
}