package pep_lvl2.arrays_strings;

// problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/container_with_most_water/ojquestion
// Leetcode: Problem 11
public class ContainerWithMostWater {
    public static int mostWater(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxVol = Integer.MIN_VALUE;
        while(i <= j){
            int l = j - i;
            int h = Math.min(heights[i], heights[j]);
            int currVol = l * h;
            maxVol = Math.max(maxVol, currVol);
            if(heights[i] > heights[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxVol;
    }
}
