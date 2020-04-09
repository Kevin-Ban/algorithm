package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {

    @Around("@annotation(spring.aop.TestAop)")
    public Object aop(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before-----");
        Object result = joinPoint.proceed();
        System.out.println("after------");
        return result;
    }
}
