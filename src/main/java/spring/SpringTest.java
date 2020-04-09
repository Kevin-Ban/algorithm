package spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import spring.config.SpringConfig;
import spring.service.MyService;

@Configuration
public class SpringTest {

    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MyService myService = context.getBean(MyService.class);
        ((AnnotationConfigApplicationContext) context).close();
//        myService.query();
    }
}
