package spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ioc.config.SpringConfig;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestEvent testEvent = new TestEvent("test", "事件消息");
        context.publishEvent(testEvent);
    }
}
