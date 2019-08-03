package reflect;

import lombok.Data;

@Data
public class TestClass extends FatherClass{

    private String privateName;

    public String publicName;

    public static String staticName;

    public final static String FINAL_NAME = "finalName";

    public TestClass(){

    }

    private void testPrivate(){
        System.out.println("调用私有方法");
    }
}
