import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static java.lang.String.format;

class Proverb {

    private final List<String> wordsPro;

    Proverb(String[] words) {
        wordsPro = Arrays.asList(words);
    }

    String recite() {
        if (wordsPro.isEmpty()) return "";

        if (onlyOneProverb(wordsPro.size())) return lastProverb();

        StringBuilder result = new StringBuilder();

        IntStream.range(0, wordsPro.size()).forEach(buildProverb(result));

        return result.toString();
    }

    private boolean onlyOneProverb(int size) {
        return size == 1;
    }

    private IntConsumer buildProverb(StringBuilder result) {
        return index -> {
            if (isLastWord(index)) {
                result.append(lastProverb());
            } else {
                result.append(format("For want of a %s the %s was lost.\n", wordsPro.get(index), wordsPro.get(index + 1)));
            }
        };
    }

    private String lastProverb() {
        return format("And all for the want of a %s.", wordsPro.get(0));
    }

    private boolean isLastWord(int index) {
        return index == wordsPro.size() - 1;
    }

}
