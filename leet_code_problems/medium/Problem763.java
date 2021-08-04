package leet_code_problems.medium;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem763 {
    // Iterative approach
    public List<Integer> partitionLabels(String s) {
        // Create an array to store the last index of every character in the given string
        int[] lastIndexLoc = new int[26];
        // Create the list to store the answer
        List<Integer> res = new ArrayList<>();

        // Store the last index of every character that occurs in the input String
        for(int i = 0; i < s.length(); i++){
            lastIndexLoc[s.charAt(i) - 'a'] = i;
        }
        // Initialize two variable first and last to mark the partitions
        int first = 0, last = 0;
        // Run the loop to finally partition the string into substrings so that each letter appears in at most one part.
        for(int i = 0; i < s.length(); i++){
            last = Math.max(lastIndexLoc[s.charAt(i) - 'a'], last);
            // Store the result and partition the array
            if(last == i){
                // Add the length
                res.add(last - first + 1);
                // Update the new start
                first = last + 1;
            }
        }
        return res;
    }
    // Recursive Approach
    public List<Integer> partitionLabelsRec(String s){
        List<Integer> finRes = new ArrayList<>();
        partitionRec(s, finRes);
        return finRes;
    }
    private void partitionRec(String s, List<Integer> res) {
        // Base case
        if(s.isEmpty())return;
        char ch = s.charAt(0);
        // find the last occurrence of current char under consideration
        int chIdx = s.lastIndexOf(ch);
        // Create a Set to store the unique chars
        HashSet<Character> hashSet = new HashSet<>();
        boolean flag = true;
        // Search a way to write this while loop properly. --> IDEA TO CODE CONVERSION IMPROVEMENT REQUIRED
        while (flag){
            // Store unique chars till the last occurrence of ch
            for (int j = 0; j <= chIdx ; j++) {
                hashSet.add(s.charAt(j));
            }
            flag = false;
            // if any character other than current char under consideration is at larger distance move the boundary there
            for (char c: hashSet) {
                // When boundary changes(expands) then only flag becomes true
                if (s.lastIndexOf(c) > chIdx){
                    chIdx = s.lastIndexOf(c);
                    flag = true;
                }
            }
        }
        // Add the result
        res.add(chIdx + 1);
        String ros = s.substring(chIdx + 1);
        // recur till string s is empty
        partitionRec(ros, res);
    }
}
