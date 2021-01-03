import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class RnaTranscription {

    private final Map<String, String> RNA_TRANSCRIPTION = Map.of(
            "G", "C",
            "C", "G",
            "T", "A",
            "A", "U"

    );

    String transcribe(String dnaStrand) {
        return  Arrays.stream(dnaStrand.split(""))
                .map(rna -> RNA_TRANSCRIPTION.getOrDefault(rna, ""))
                .collect(Collectors.joining());
    }

}
