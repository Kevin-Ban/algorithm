package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import spring.aop.config.SpringConfig;
import spring.aop.service.TestAopService;

@Component
public class Test {

    @org.junit.jupiter.api.Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestAopService testAopService = context.getBean(TestAopService.class);
        testAopService.test1();
        //使用spring aop动态代理实际上是使用JDK或者cglib生成了一个新的代理对象
        System.out.println(testAopService.getClass());
    }
}
