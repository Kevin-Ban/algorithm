package test;

/**
 * 对于强制转换来说，基本上时截取整数部分，丢弃小数部分
 */
public class TestInteger {

    public static void main(String[] args) {
        double d = 0.4;
        double d1 = 0.9;
        float f = 0.1f;
        float f1 = 0.9f;
        System.out.println("d:" + (int) d);
        System.out.println("d1:" + (int) d1);
        System.out.println("f:" + (int) f);
        System.out.println("f1:" + (int) f1);
    }
}
