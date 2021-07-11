package com.example.test2.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConfirmNumber.class)
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD, ElementType.FIELD ,ElementType.PARAMETER})
public @interface PhoneType {
    String message() default "The number should follow {value}";
    Company value();

}
