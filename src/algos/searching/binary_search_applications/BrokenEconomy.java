package algos.searching.binary_search_applications;
import java.util.Scanner;

/* Question prompt link
* https://classroom.pepcoding.com/myClassroom/the-switch-program-3/function-and-arrays/ceil-floor-official/ojquestion
* */
public class BrokenEconomy {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }
        int denomination = sc.nextInt();
        getCeilAndFloor(arr, denomination);
        sc.close();
    }
    private static void getCeilAndFloor(int[] arr, int denomination) {
        int ceil = -1;
        int floor = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (arr[mid] == denomination) {
                ceil = floor = arr[mid];
                break;
            } else if (arr[mid] < denomination) {
                floor = arr[mid];
                left = mid + 1;
            } else {
                ceil = arr[mid];
                right = mid - 1;
            }
        }
        System.out.println(ceil + "\n" + floor);
    }
}
