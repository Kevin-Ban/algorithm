package spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import spring.service.MyService;

public @Component
class MyServicePostProccessors implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyService) {
            System.out.println("BeanPostProcessor：postProcessBeforeInitialization");
            ((MyService) bean).query();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyService) {
            System.out.println("BeanPostProcessor：postProcessAfterInitialization 此时bean已经完全创建");
            ((MyService) bean).query();
        }
        return bean;
    }
}