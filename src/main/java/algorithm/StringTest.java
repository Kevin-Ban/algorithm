package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringTest {

    public static void main(String[] args){
        List<String> list = new ArrayList();
        list.add("小明");
        list.add("小红");
        list.add("Kevin");
        list.add("Karl");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            if(i == 0){
                sb.append(list.get(i));
            }else{
                sb.append("," + list.get(i));
            }
        }
        System.out.println(sb.toString());

        String result = String.join(",", list);
        System.out.println(result);

        String result1 = list.stream().filter(c -> c.startsWith("K")).collect(Collectors.joining(","));
        System.out.println(result1);
    }
}
