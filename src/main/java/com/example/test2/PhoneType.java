package com.example.test2;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConfirmNumber.class)
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD, ElementType.FIELD ,ElementType.PARAMETER})
public @interface PhoneType {
    String message() default "The number should follow {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Company value();

}
