package miscelleneous_problems.strings;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesString {
    public static void main(String[] args){
        String text = "leetcodeleet";
        System.out.println(countDuplicates(text));
    }

    private static Map<Character, Integer> countDuplicates(String text){
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : text.toCharArray()){
            if(map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else{
                map.put(ch, 1);
            }
        }
        return map;
    }
}
