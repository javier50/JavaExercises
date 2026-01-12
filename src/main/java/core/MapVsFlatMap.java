package core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world");

        List<List<String>> mapped = MapVsFlatMap.map(words).collect(Collectors.toList());
        System.out.println(mapped);// Output: [[h, e, l, l, o], [w, o, r, l, d]]

        List<String> flatMapped = MapVsFlatMap.flatMap(words).collect(Collectors.toList());
        System.out.println(flatMapped);// Output: [h, e, l, l, o, w, o, r, l, d]
    }

    private static Stream<List<String>> map(List<String> words){
        return words.stream()// map each word to a list of characters
                .map(word -> Arrays.asList(word.split("")));
    }

    private static Stream<String> flatMap(List<String> words){
        return words.stream()// flatMap each word to characters
                .flatMap(word -> Arrays.stream(word.split("")));
    }
}
