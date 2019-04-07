package designPattern.proxy.jdk;

public class SayEnglishImpl implements Say {
    @Override
    public String sayHello(String words) {
        System.out.println("English: " + words);
        return words;
    }
}
