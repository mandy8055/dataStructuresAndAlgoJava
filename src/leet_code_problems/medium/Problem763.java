package leet_code_problems.medium;
import java.util.ArrayList;
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
}
