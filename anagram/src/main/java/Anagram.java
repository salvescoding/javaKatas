import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Anagram {


    private final Map<String, Long> anagram;
    private final String originalAnagram;

    public Anagram(String anagram) {
        this.anagram = Arrays.stream(anagram.toLowerCase(Locale.ROOT).split(""))
                .collect(groupingBy(c -> c, Collectors.counting()));
        this.originalAnagram = anagram;
    }


    public List<String> match(List<String> words) {
        return words.stream()
                .filter(word -> !word.toLowerCase(Locale.ROOT).equals(originalAnagram.toLowerCase(Locale.ROOT)))
                .filter(this::isAnagram)
                .collect(Collectors.toList());
    }

    private boolean isAnagram(String word ) {
        return Arrays.stream(word.toLowerCase(Locale.ROOT).split(""))
                .collect(groupingBy(c -> c, Collectors.counting())).equals(anagram);
    }
}