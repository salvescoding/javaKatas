import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Anagram {


    private final String anagram;

    public Anagram(String anagram) {
        this.anagram = anagram;
    }


    public List<String> match(List<String> words) {
        final int[] anagramToCompare = anagram.toLowerCase().chars().sorted().toArray();
        return words.stream()
                .filter(word ->  Arrays.equals(anagramToCompare, word.toLowerCase(Locale.ROOT).chars().sorted().toArray())
                    && !word.toLowerCase(Locale.ROOT).equals(anagram.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }
}