package spring.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyService implements InitializingBean {

    @Autowired
    private YourService yourService;

    private String field = "myService";

    public MyService() {
        System.out.println("构造函数：正在创建对象");
    }

    public void query() {
        System.out.println("bean里面的方法：" + this.field + "=========");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean方法被执行");
    }

    @PostConstruct
    public void init() {
        System.out.println("构造方法执行完成之后@PostConstruct：init");
    }
}
