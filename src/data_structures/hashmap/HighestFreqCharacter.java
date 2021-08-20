package data_structures.hashmap;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
// Problem link: https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/hfc-official/ojquestion#!

public class HighestFreqCharacter {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str = sc.next();
        System.out.println(getHighestFreqChar(str));
        sc.close();
    }

    private static char getHighestFreqChar(@NotNull String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                int of = map.get(ch);
                int nf = of + 1;
                map.put(ch, nf);
            } else {
                map.put(ch, 1);
            }
        }
        char res = str.charAt(0);
        for (char ch : map.keySet()) {
            if (map.get(res) < map.get(ch)) {
                res = ch;
            }
        }
        return res;
    }
}
