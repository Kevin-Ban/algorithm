package other.generic.test1;

public class Test {

    public static void main(String[] args) {
        Animal<Integer> animal = new Animal<>();
        animal.setAge(9);
        System.out.println(String.format("类型为：%s，值为：%s", animal.getAge().getClass(), animal.getAge()));

        Animal<String> animal1 = new Animal<>();
        animal1.setAge("9岁");
        System.out.println(String.format("类型为：%s，值为：%s", animal1.getAge().getClass(), animal1.getAge()));
    }
}
