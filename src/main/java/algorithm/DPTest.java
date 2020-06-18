package algorithm;


import com.alibaba.fastjson.JSONObject;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DPTest {

    public static void main(String[] args) {
//        System.out.println(f1(4));
//        int[] a = new int[]{1,9,4,2,4,7,5,1,2,5,7,2};
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Double fl = 3.0D;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.comparingInt(c2 -> c2));
        System.out.println(fl.equals(d));
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == a + b);
        System.out.println(c.equals(a + b));
        System.out.println(g == (long) (a + b));
        System.out.println(g.equals(a + b));
        ThreadLocal<Map<String, Object>> threadLocal = ThreadLocal.withInitial(HashMap::new);
        Map<String, Object> map = threadLocal.get();
        map.put("123", "hhhh");
        System.out.println(JSONObject.toJSONString(map));
        System.out.println("");
        threadLocal.set(new HashMap<>());
        Map map1 = threadLocal.get();
        System.out.println(JSONObject.toJSONString(map1));
    }

    /**
     * 动态规划解决斐波那契数列
     * 时间复杂度O(n),空间复杂度O(1)
     */
    public static int f(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    /**
     * 动态规划计算阶乘
     *
     * @param n
     * @return
     */
    public static int f1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int result = 2;
        for (int i = 3; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
