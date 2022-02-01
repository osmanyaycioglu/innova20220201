package com.training.spring.postprocessor;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object beanParam,
                                                  final String beanNameParam) throws BeansException {
        // System.out.println("Before Bean : " + beanNameParam);
        return beanParam;
    }

    @Override
    public Object postProcessAfterInitialization(final Object beanParam,
                                                 final String beanNameParam) throws BeansException {
        // System.out.println("After Bean : " + beanNameParam);
        Class<?> classLoc = beanParam.getClass();
        BeanProc annotationLoc = classLoc.getAnnotation(BeanProc.class);
        if (annotationLoc != null) {
            try {
                Field fieldLoc = classLoc.getDeclaredField("name");
                fieldLoc.setAccessible(true);
                fieldLoc.set(beanParam,
                             beanNameParam);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return beanParam;
    }
}
