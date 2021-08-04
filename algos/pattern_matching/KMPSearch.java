package algos.pattern_matching;

import java.util.Arrays;

public class KMPSearch {
    public static void main(String[] args) {
        String text = "AABBACAADAABAABA";
//        String text = "abxabcabcaby";
//        String pattern = "abcaby";
        String pattern = "AABA";
        if(KMP(text, pattern) != -1){
            System.out.println("Pattern found at index: " + KMP(text, pattern));
        }else{
            System.out.println("Pattern not found.");
        }
    }

    private static int KMP(String text, String pattern) {
        int[] piArr = constructPiArray(pattern);
        int i = 0;
        int j = 0;
        int counter = 0;
        while(i < text.length() && counter != pattern.length()){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                counter++;
            }else{
                if(j != 0) {
                    j = piArr[j - 1];
                }
                else{
                    i++;
                }
                counter = j;
            }
        }
        if(counter == pattern.length()){
            return (i - j);
        }
        return -1;
    }


    //  Construction of PI Array
    private static int[] constructPiArray(String pattern) {
        int patLength = pattern.length() - 1;
        int[] lpArr = new int[pattern.length()];
        lpArr[0] = 0;
        int i = 1;
        int j = 0;
        while (i <= patLength) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lpArr[i] = j + 1;
                j++;
                i++;
            } else {
                if (j != 0) {
                    j = lpArr[j - 1];
                } else {
                    lpArr[i] = j;
                    i++;
                }
            }
        }
//        return Arrays.stream(lpArr).max().getAsInt();
        return lpArr;
//        Arrays.stream(lpArr).forEach(num -> System.out.print(num + " "));

    }

}
