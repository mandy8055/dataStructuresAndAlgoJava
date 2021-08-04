package miscelleneous_problems.strings;

/*Questions link: https://pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/string-with-difference-of-every-two-consecutive-characters-official/ojquestion#!
* */
import java.util.Scanner;
public class StringWithDifference {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.next();
        System.out.println(differenceOfString(str));
        sc.close();
    }

    public static String differenceOfString(String str) {
        StringBuilder sb = new StringBuilder();
        char ch1 = str.charAt(0);
        sb.append(ch1);
        for (int i = 1; i < str.length(); i++) {
            int diff = str.charAt(i) - ch1;
            sb.append(diff);
            sb.append(str.charAt(i));
            ch1 = str.charAt(i);
        }
        return sb.toString();
    }

}
