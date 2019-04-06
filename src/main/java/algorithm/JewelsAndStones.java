package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JewelsAndStones {

    /**
     * https://leetcode.com/problems/jewels-and-stones/
     *
     */
    public int numJewelsInStones(String J, String S) {
        if(J.isEmpty() || S.isEmpty()){
            return 0;
        }
        Set<String> set = new HashSet<>();
        List<String> list = Arrays.asList(J.split(""));
        list.forEach(c -> {
            set.add(c);
        });
        List list1 = Arrays.asList(S.split(""));
        Integer result = 0;
        for(String s : set){
            long tmp = list1.stream().filter(c -> c.equals(s)).count();
            
            result = result + (int)tmp;
        }
        return result;
    }

    public int numJewelsInStones1(String J, String S) {
        if(J.isEmpty() || S.isEmpty()){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < S.length(); i++){
            int index = J.indexOf(S.charAt(i));
            if(index > 0){
                result++;
            }
        }
        return result;
    }

}
