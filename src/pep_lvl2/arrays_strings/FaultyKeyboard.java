package pep_lvl2.arrays_strings;
// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/faulty_keyboard/ojquestion
// Leetcode: problem 925

public class FaultyKeyboard {
    public static boolean isPossible(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i - 1 >= 0 && name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        while (j < typed.length()) {
            if (typed.charAt(j) != name.charAt(name.length() - 1)) {
                return false;
            }
            j++;
        }
        return !(i < name.length());
    }
}
