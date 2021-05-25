package algos.searching.binary_search_applications;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SquareRootWithoutUsingLib {
    public static int squareRoot(int number){
        if(number == 0)return 0;
        int i = 0, j = number;
        int result = 0;
        while(i <= j){
            int mid = (int)Math.floor((i + j) / 2);
            if(mid <= (number / mid)){
                result = mid;
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return result;
    }
}
