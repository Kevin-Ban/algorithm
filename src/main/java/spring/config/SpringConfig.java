package spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring")
public class SpringConfig {

    /**
     * 条件加载机制
     */
    public final static boolean FLAG = true;
}
