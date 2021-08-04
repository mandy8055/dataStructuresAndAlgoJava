package miscelleneous_problems.strings;

/* Question's link: https://pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/string-compression-official/ojquestion#!*/
import java.util.Scanner;
public class StringCompression {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
        sc.close();
    }
    public static String compression1(String str) {
        char ch1 = '\0';
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(ch != ch1){
                sb.append(ch);
                ch1 = ch;
            }
        }
        return sb.toString();
    }

    public static String compression2(String str) {
        StringBuilder sb =  new StringBuilder();
        int counter = 1;
        char ch1 = str.charAt(0);
        sb.append(ch1);
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) != ch1){
                if(counter != 1){
                    sb.append(counter);
                    counter = 1;
                }
                sb.append(str.charAt(i));
                ch1 = str.charAt(i);
            }else{
                counter++;
            }
        }
        if(counter != 1){
            sb.append(counter);
        }
        return sb.toString();
    }
}
