package algorithm;

import java.util.*;

public class DuplicateString {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(removeDuplicate(s));
    }

    public static String removeDuplicate(String s){
        Set<String> set = new HashSet(Arrays.asList(s.split("")));
        return String.join("", set);
    }
}
