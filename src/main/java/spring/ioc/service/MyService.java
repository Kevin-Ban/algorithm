package spring.ioc.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 条件加载
 */
@Conditional(ConditionService.class)
@Component
public class MyService implements InitializingBean, DisposableBean {

    @Autowired
    private YourService yourService;

    private String field = "myService";

    public MyService() {
        System.out.println("bean的构造函数");
    }

    public void query() {
        System.out.println("bean里面的方法：" + this.field + "=========");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean -> afterPropertiesSet");
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy");
    }

    @Override
    public void destroy() {
        System.out.println("DisposableBean -> destroy");
    }
}
