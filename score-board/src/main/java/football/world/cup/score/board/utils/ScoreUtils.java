package football.world.cup.score.board.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.trim;
public class ScoreUtils {

    private final static Logger LOG = LoggerFactory.getLogger(ScoreUtils.class);
    private final static String PATTERN = "([a-z ]*-[a-z ]*):([0-9 ]*-[0-9 ]*)";

    public static Optional<Map<String, Integer>> validateScore(final String score) {
        if (!isScoreInCorrectPattern(score)) {
            LOG.error("Score have incorrect format!");
            return Optional.empty();
        }
        return createMapWithScore(score.split("[:-]"));
    }

    public static boolean isScoreInCorrectPattern(final String score) {
        final Pattern pattern = Pattern.compile(PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(score).find();
    }

    private static Optional<Map<String, Integer>> createMapWithScore(final String[] scoreArray) {
        final Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put(trim(scoreArray[0]), Integer.valueOf(trim(scoreArray[2])));
        scoreMap.put(trim(scoreArray[1]), Integer.valueOf(trim(scoreArray[3])));
        return Optional.of(scoreMap);
    }
}
