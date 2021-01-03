import java.util.stream.IntStream;

class ReverseString {

    String reverse(String inputString) {
        StringBuilder result = new StringBuilder();
        int totalSize = inputString.length();
        IntStream.range(0, totalSize)
                .map(i -> totalSize - i - 1)
                .forEach(index -> result.append(inputString.charAt(index)));
        return result.toString();
    }
}