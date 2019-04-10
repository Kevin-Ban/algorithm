package generic;

public class EnglishTest implements TestInterface<EnglishBean> {

    @Override
    public EnglishBean list(EnglishBean englishBean) {
        return new EnglishBean("123654");
    }

    public static void main(String[] args){
        EnglishTest tmp = new EnglishTest();
        EnglishBean tmp1 = tmp.list(null);
        System.out.println(tmp1.getParam());
    }
}
