package com.yixuan.receiptProcess.receiptProcess.Service.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateTimeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateTime {
    String message() default "Invalid time.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
