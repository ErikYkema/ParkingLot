package com.dojo.parkinglot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

/*
enable AOP by enabling the aop entry in applicationContext.xml
 */
@Aspect
@Component
public class LoggingAspect {

    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

   // does not work to catch constructor invocations...
   @Before("execution(*.new(..))")
    public void constructors() {
        LOG.info("AOP - Constructor...");
    }

    @Before("execution(public * *(..))")
    public void before(JoinPoint jp) {
        LOG.info("before " + jp.getStaticPart().toString());
    }

}
