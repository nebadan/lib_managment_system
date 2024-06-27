package com.itsc.library_managment_system.lib_managment_system.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  @Pointcut("execution(* com.itsc.library_managment_system.lib_managment_system.service.*(..))")
  public void serviceMethods() {
  }

  @AfterReturning("serviceMethods()")
  public void logAfterReturning() {
    System.out.println("A method in the BookService was executed.");
  }
}
