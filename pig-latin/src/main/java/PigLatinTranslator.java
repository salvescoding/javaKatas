import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    private final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
    private final List<String> vowelSound = List.of("xr", "yt");
    private final List<String> consonantSound = List.of("sch", "thr", "qu", "ch", "th" );

    public String translate(String pigLatin) {
        return Arrays.stream(pigLatin.split(" ")).map(this::mapWord).collect(Collectors.joining(" "));
    }

    private String mapWord(String pigLatin) {
        StringBuilder result = new StringBuilder();
        Character firstChar = pigLatin.charAt(0);
        String firstTwoChars = pigLatin.substring(0, 2);


        if (isAVowel(firstChar) || pigLatin.startsWith("xr")) {
            return result.append(pigLatin).append("ay").toString();
        }

        if (isNotAVowel(firstChar)) {

            if (pigLatin.charAt(1) == 'y') {
                return result.append(pigLatin, 1, pigLatin.length()).append(firstChar).append("ay").toString();
            }

            if (pigLatin.startsWith("rhy")) {
                return result.append(pigLatin, 2, pigLatin.length()).append(firstTwoChars).append("ay").toString();
            }

            if (pigLatin.startsWith("qu", 1)) {
                return result.append(pigLatin, 3, pigLatin.length()).append(firstChar).append("quay").toString();

            }
            if (consonantSound.stream().anyMatch(pigLatin::contains)) {
                String consonant = consonantSound.stream().filter(cs -> cs.equals(pigLatin.substring(0, cs.length()))).findFirst().orElse("");
                return result.append(pigLatin, consonant.length(), pigLatin.length()).append(consonant).append("ay").toString();
            }
            else {
                return result.append(pigLatin, 1, pigLatin.length()).append(firstChar).append("ay").toString();
            }
        }
        return result.toString();
    }

    private boolean isAVowel(Character firstChar) {
        return vowels.contains(firstChar);
    }

    private boolean isNotAVowel(Character firstChar) {
        return !isAVowel(firstChar);
    }
}
