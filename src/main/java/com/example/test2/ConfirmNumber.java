package com.example.test2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmNumber implements ConstraintValidator<PhoneType,String> {




    @Override
    public void initialize(PhoneType constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return(s.contains("059"));
    }

}
