package other.generic.test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("s1");
        strings.add("s2");
        System.out.println(getString(strings));

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        System.out.println(getString(integers));

        List<Map> list1 = new ArrayList<>();
        System.out.println(getString1(list1));

        List<Map> list = new ArrayList<>();
        System.out.println(getString1(list));
    }

    public static String getString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.valueOf(list.get(i)));
        }
        return sb.toString();
    }

    public static String getString1(List<? super MyMap> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.valueOf(list.get(i)));
        }
        return sb.toString();
    }

    public static String getString2(List<? extends Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.valueOf(list.get(i)));
        }
        return sb.toString();
    }
}

class MyMap extends HashMap {

}