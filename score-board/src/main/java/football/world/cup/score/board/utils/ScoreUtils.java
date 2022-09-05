package football.world.cup.score.board.utils;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class ScoreUtils {

    private final static String PATTERN = "([a-z ]*-[a-z ]*):([0-9 ]*-[0-9 ]*)";

    public static Optional<Map<String, Integer>> validateScore(final String score) {
        return Optional.empty();
    }

    public static boolean isScoreInCorrectPattern(final String score) {
        final Pattern pattern = Pattern.compile(PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(score).find();
    }
}
