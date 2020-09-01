package test;

import java.util.LinkedList;
import java.util.List;

public class TestByte {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        int i = 0;
        while (true) {
            list.add("测试测试测试测试测试测试测试测试测试测试测试测试" + i);
            i++;
        }
    }
}
