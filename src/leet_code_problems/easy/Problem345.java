package leet_code_problems.easy;

public class Problem345 {
    public String reverseVowels(String s){
        int i = 0;
        int j = s.length() - 1;
        char[] ch = s.toCharArray();
        while(i < j){
            if(!isVowel(ch[i])){
                i++;
            }else if(!isVowel(ch[j])){
                j--;
            }else{
                swap(ch, i, j);
                i++;
                j--;
            }
        }
        return new String(ch);
    }
    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static boolean isVowel(char ch){
        return ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i'
                || ch == 'O' || ch == 'o' || ch == 'U' || ch == 'u';
    }
}
