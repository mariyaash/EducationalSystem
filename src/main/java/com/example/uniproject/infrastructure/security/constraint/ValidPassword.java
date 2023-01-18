package com.example.uniproject.infrastructure.security.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidPassword {
    String message() default "Password should be at least 8 characters, one uppercase, one lowercase, one digit, and a special symbol!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
