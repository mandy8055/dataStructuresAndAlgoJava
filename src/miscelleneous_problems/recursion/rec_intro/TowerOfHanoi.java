package miscelleneous_problems.recursion.rec_intro;
import java.util.Scanner;
/*Question link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/introduction-to-recursion/toh-official/ojquestion
* */
public class TowerOfHanoi {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int num = sc.nextInt();
        int t1id = sc.nextInt();
        int t2id = sc.nextInt();
        int t3id = sc.nextInt();
        towerOfHanoi(num, t1id, t3id, t2id);
        sc.close();

    }
    private static void towerOfHanoi(int num, int l, int m, int r){
        if(num == 0)return;
        towerOfHanoi(num - 1, l, r, m);
        System.out.println(num + "[" + l + " -> " + r + "]");
        towerOfHanoi(num - 1, m, l, r);
    }
}
