package com.training.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "my.aspect.enabled", havingValue = "true", matchIfMissing = false)
@Component
@Aspect
public class MyAopEnforcer {


    private static final Logger logger = LoggerFactory.getLogger(MyAopEnforcer.class);

    //@Around("within(com.training.spring..*) && @annotation(log)")
    @Around("@annotation(log)")
    public Object logcuAround(final ProceedingJoinPoint pjp,
                              final Logcu log) {
        try {
            String logLevelLoc = log.value();

            long delta = System.nanoTime();
            Object proceedLoc = pjp.proceed();
            switch (logLevelLoc) {
                case "DEBUG":
                    MyAopEnforcer.logger.debug(pjp.getSignature() + " Delta : " + (System.nanoTime() - delta));
                    break;
                case "INFO":
                default:
                    MyAopEnforcer.logger.info(pjp.getSignature() + " Delta : " + (System.nanoTime() - delta));
                    break;

            }
            System.out.println(pjp.getSignature() + " Delta : " + (System.nanoTime() - delta));
            return proceedLoc;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }


    @Around("execution(* com.training.spring.aop.CallMe.*(..))")
    public Object helloAround(final ProceedingJoinPoint pjp) {
        try {
            long delta = System.nanoTime();
            Object[] argsLoc = pjp.getArgs();
            String name = (String) argsLoc[0];
            if (name.equals("osman")) {
                Object[] objectsLoc = new Object[1];
                objectsLoc[0] = "alice";
                Object proceedLoc = pjp.proceed(objectsLoc);
                return proceedLoc;
            } else {
                Object proceedLoc = pjp.proceed();
                System.out.println(pjp.getSignature() + " Delta : " + (System.nanoTime() - delta));
                if (proceedLoc instanceof String) {
                    String str = (String) proceedLoc;
                    return "Intercepted " + str;
                }
                return proceedLoc;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }


    @Pointcut("execution(* com.training.spring.aop.CallMe.*(..)) && args(xyz)")
    public void helloIntercept(final String xyz) {

    }

    //@Before("execution(* com.training.spring.aop.CallMe.*(..)) && args(xyz)")
    @Before("helloIntercept(xyz)")
    public void beforeHello(final String xyz) {
        System.out.println("com.training.spring.aop.CallMe.hello cağrılmadan önce -> " + xyz);
    }

    // @After("execution(* com.training.spring.aop.CallMe.*(..)) && args(xyz)")
    @After("helloIntercept(xyz)")
    public void afterHello(final String xyz) {
        System.out.println("com.training.spring.aop.CallMe.hello cağrıldıktan sonra -> " + xyz);
    }

    @AfterReturning(value = "execution(* com.training.spring.aop.CallMe.*(..)) && args(xyz)", returning = "retVal")
    public void afterHello(final JoinPoint jp,
                           final String xyz,
                           final String retVal) {
        System.out.println(jp.getSignature() + " cağrıldıktan sonra " + xyz + " ret : " + retVal);
    }

}
