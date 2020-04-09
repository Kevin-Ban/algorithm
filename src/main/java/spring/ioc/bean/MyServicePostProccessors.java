package spring.ioc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import spring.ioc.service.MyService;

public @Component
class MyServicePostProccessors implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyService) {
            System.out.println("BeanPostProcessor -> postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyService) {
            System.out.println("BeanPostProcessor -> postProcessAfterInitialization");
        }
        return bean;
    }
}