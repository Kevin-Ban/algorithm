package generic;

import java.util.List;

public class Test {

    public static void main(String[] args){
        LanguageExecute<ChineseBean> languageExecute = new LanguageExecute(new ChineseTest());
        List<ChineseBean> list = languageExecute.list(null);
        System.out.println(list);

    }
}
