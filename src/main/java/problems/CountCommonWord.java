package problems;

import java.util.HashMap;
import java.util.Map;

public class CountCommonWord {
    static final String text = "Mr. Phileas Fogg lived, in 1872, at No. 7, Saville Row, Burlington Gardens, the house in which Sheridan died in 1814. He was one of the most noticeable members of the Reform Club, though he seemed always to avoid attracting attention; an enigmatical personage, about whom little was known, except that he was a polished man of the world. People said that he resembled Byron--at least that his head was Byronic; but he was a bearded, tranquil Byron, who might live on a thousand years without growing old. ";

    public static void main(String[] args) throws Exception {
        String word = "";
        int max = 0;
        String[] stAr = text.replace(",", "").replace(".", "").split(" ");
        Map<String, Integer> stMap = new HashMap<>();
        for (String st : stAr) {
            if (stMap.containsKey(st)) {
                stMap.replace(st, stMap.get(st) + 1);
            } else {
                stMap.put(st, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : stMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                word = entry.getKey();
            }
        }

        System.out.printf("Word: %s, Count: %d\n", word, max);

        stMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).forEach(item -> {
                    System.out.printf("Word: %s, Count: %d\n", item.getKey(), item.getValue());
                });
    }

}
