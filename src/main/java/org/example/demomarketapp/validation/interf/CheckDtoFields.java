package org.example.demomarketapp.validation.interf;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.demomarketapp.validation.constraint.AnnotationCheckerDtoFields;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AnnotationCheckerDtoFields.class})
public @interface CheckDtoFields {


    String message() default "Entity such field its does exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
