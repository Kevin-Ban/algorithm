package spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class FactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("myService");
//        System.out.println("BeanFactory生成成功之后获取到的BeanDefinition对象里面的信息：" + beanDefinition);
    }
}
