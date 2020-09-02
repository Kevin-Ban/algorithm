package test;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class TestByte {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        TreeMap<String, String> map = new TreeMap<>();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int i = 0;
        while (true) {
            list.add("测试测试测试测试测试测试测试测试测试测试测试测试" + i);
            i++;
        }
    }
}
