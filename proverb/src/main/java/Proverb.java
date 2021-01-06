import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;

class Proverb {

    private final List<String> wordsPro;

    Proverb(String[] words) {
        wordsPro = Arrays.asList(words);
    }

    String recite() {
        return IntStream.range(0,wordsPro.size()).mapToObj(this::buildProverb).collect(Collectors.joining("\n"));
    }


    private String buildProverb(int index) {
        return isLastWord(index) ? lastProverb() :
                format("For want of a %s the %s was lost.", wordsPro.get(index), wordsPro.get(index + 1));
    }

    private String lastProverb() {
        return format("And all for the want of a %s.", wordsPro.get(0));
    }

    private boolean isLastWord(int index) {
        return index == wordsPro.size() - 1;
    }

}
