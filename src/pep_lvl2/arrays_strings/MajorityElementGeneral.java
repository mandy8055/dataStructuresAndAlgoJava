package pep_lvl2.arrays_strings;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/majority-element-general/ojquestion

public class MajorityElementGeneral {
    public static @NotNull ArrayList<Integer> majorityElement(int @NotNull [] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // element -> freq
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        int req = arr.length / k;
        for (Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() > req){
                res.add(e.getKey());
            }
        }
        return res;
    }
}
