package spring.aop.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {

    @Around("@annotation(spring.aop.service.TestAop)")
    public Object aop(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around");
        Object result = joinPoint.proceed();
        return result;
    }

    @Before("@annotation(spring.aop.service.TestAop)")
    public void before() {
        System.out.println("before");
    }

    @After("@annotation(spring.aop.service.TestAop)")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("@annotation(spring.aop.service.TestAop)")
    public void afterReturn() {
        System.out.println("afterReturn");
    }

    @AfterThrowing("@annotation(spring.aop.service.TestAop)")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }
}
