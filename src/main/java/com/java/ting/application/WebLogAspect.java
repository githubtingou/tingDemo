package com.java.ting.application;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 切面
 *
 * @author TingOu
 */
@Aspect
@Order(5)
@Component
@Slf4j
public class WebLogAspect {
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Pointcut("execution(public *  com.java.ting.dev..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        /**
         * 记录下请求内容
         */
        // 请求路径
        log.info("URL : {}", request.getRequestURL().toString());
        // 请求方式
        log.info("HTTP_METHOD : {} ", request.getMethod());
        // 请求IP
        log.info("IP : {}", request.getRemoteAddr());
        // 请求方法名
        log.info("CLASS_METHOD : {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // 请求参数
        log.info("ARGS : {}", joinPoint.getArgs());

    }

    /**
     * 处理完请求，返回内容
     *
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {

        // 返回参数
        log.info("RESPONSE : {}", ret);
        log.info("SPEND TIME : {}", (System.currentTimeMillis() - startTime.get()));
    }
}
