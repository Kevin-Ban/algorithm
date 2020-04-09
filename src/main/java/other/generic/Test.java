package other.generic;

public class Test {

    public static void main(String[] args){
        ChineseTest test = new ChineseTest();
        BaseBean bean = test.list(null);
        System.out.println(bean);
    }
}
