package leet_code_problems.medium;

public class Problem1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        // Create the frequency arrays for both the Strings
        int[] frq_s1 = new int[26];
        int[] frq_s2 = new int[26];
        // Store the count of occurrence of each characters in frq_s1 and frq_s2
        for(int i = 0; i < s1.length(); i++){
            frq_s1[s1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s2.length(); i++){
            frq_s2[s2.charAt(i) - 'a']++;
        }
        // Initialize counters to count the cumulative sum of each character
        int counter1 = 0, counter2 = 0;
        // Initialize the isSmall flags to mark which of the string is smaller
        boolean isSmall1 = false, isSmall2 = false;
        // Run a loop till number of alphabets time.
        for(int i = 0; i < 26; i++){
            counter1 += frq_s1[i];
            counter2 += frq_s2[i];

            // Check if s1 is lexicographically smaller
            if(counter1 > counter2){
                // If s2 is already smaller then we cannot break the string s1 using s2
                if(isSmall2){
                    return false;
                }
                isSmall1 = true;

            }else if(counter2 > counter1){
                // If s1 is already smaller then we cannot break the string s2 using s1
                if(isSmall1){
                    return false;
                }
                isSmall2 = true;
            }
        }
        return true;
    }
}
