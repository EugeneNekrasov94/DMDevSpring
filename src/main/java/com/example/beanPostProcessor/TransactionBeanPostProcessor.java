package com.example.beanPostProcessor;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.simple.SimpleLoggerContextFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Log4j2
public class TransactionBeanPostProcessor implements BeanPostProcessor {
    Logger logger = org.apache.logging.log4j.core.Logger.

    private final Map<String,Class<?>> taBeans = new HashMap<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Transaction.class)) {
            taBeans.put(beanName,bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = taBeans.get(beanName);

        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                log.info("Open transaction!");
                try {
                    method.invoke(bean,args);
                } finally {
                    log.info("Close TA!");
                }
                return bean;
            });
        }
        return bean;
    }
}
