package com.example.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

public class JpaCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        try {
            Objects.requireNonNull(context.getClassLoader()).loadClass("org.postdgresql.Driver");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
