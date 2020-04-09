package spring.aop;

import org.springframework.stereotype.Component;

@Component
public class TestAopService {

    @TestAop
    public String test1() {
        System.out.println("方法体");
        return "test1方法";
    }
}
