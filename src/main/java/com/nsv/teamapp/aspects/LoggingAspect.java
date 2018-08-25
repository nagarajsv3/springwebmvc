package com.nsv.teamapp.aspects;

import com.nsv.teamapp.domains.Team;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);

    @Around("execution(* com.nsv.teamapp.services.TeamServiceImpl.*(*))")
    public Object printMethodNameWithArguments(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();

        if(args.length>0){
            if(args[0] instanceof Team){
                LOGGER.info("AspectLogging Executing the method name: "+methodName + " with arguments "+((Team)args[0]).toString());
            }

        }else{
            LOGGER.info("AspectLogging Executing the method name: "+methodName);
        }

        Object proceed = proceedingJoinPoint.proceed();

        if(args.length>0){
            if(args[0] instanceof Team){
                LOGGER.info("AspectLogging Executed the method name: "+methodName + " with arguments "+((Team)args[0]).toString());
            }

        }else{
            LOGGER.info("AspectLogging Executed the method name: "+methodName);
        }

        return proceed;
    }

    @Before("args(id)")
    public void beforeAdvice(int id){
        LOGGER.info("Before Advice");
    }


    @Before("getNamePointcut()")
    public void secondAdvice(){
        System.out.println("Executing with the help of Pointcut on getName()");
    }

    @Pointcut("execution(public String getName())")
    public void getNamePointcut(){}


    //Pointcut to execute on all the methods of classes in a package
    @Pointcut("within(com.nsv.teamapp..*)")
    public void allMethodsPointcut(){}




}