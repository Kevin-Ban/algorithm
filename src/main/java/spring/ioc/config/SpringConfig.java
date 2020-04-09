package spring.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("spring")
public class SpringConfig {

    /**
     * 条件加载机制
     */
    public final static boolean FLAG = true;
}
