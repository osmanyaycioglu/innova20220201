package com.training.spring.conditional;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CheckEnvImpl implements Condition {

    @Override
    public boolean matches(final ConditionContext contextParam,
                           final AnnotatedTypeMetadata metadataParam) {
        Environment environmentLoc = contextParam.getEnvironment();
        MergedAnnotations annotationsLoc = metadataParam.getAnnotations();
        MergedAnnotation<CheckEnv> mergedAnnotationLoc = annotationsLoc.get(CheckEnv.class);
        if (mergedAnnotationLoc == null) {
            return false;
        }
        Map<String, Object> asMapLoc = mergedAnnotationLoc.asMap();
        String keyLoc = (String) asMapLoc.get("key");
        String valueLoc = (String) asMapLoc.get("value");
        String propertyLoc = environmentLoc.getProperty(keyLoc);
        if (propertyLoc == null) {
            return false;
        }
        if (propertyLoc.equals(valueLoc)) {
            return true;
        }
        return false;
    }

}
