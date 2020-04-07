package designPattern.proxy.jdk;

public class SayChineseImpl implements Say {
    @Override
    public String sayHello(String words) {
        String s = "说中文。";
        System.out.println(s);
        return s;
    }
}
