package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import spring.aop.config.SpringConfig;

@Component
public class Test {

    @org.junit.jupiter.api.Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestAopService testAopService = context.getBean(TestAopService.class);
        testAopService.test1();
    }
}
