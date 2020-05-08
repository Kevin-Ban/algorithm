package algorithm;

/**
 * 动态规划解决斐波那契数列
 * 时间复杂度O(n),空间复杂度O(1)
 */
public class DPTest {

    public static void main(String[] args) {
        System.out.println(f(4));
    }

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
}
