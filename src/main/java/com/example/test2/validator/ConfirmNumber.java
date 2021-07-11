package com.example.test2.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ConfirmNumber implements ConstraintValidator<PhoneType,String> {

    private Company comp;
    @Override
    public void initialize(PhoneType constraintAnnotation) {
        this.comp= constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(comp == Company.JAWAL){
            return s.substring(0,3).equals("059");
        }else{
            return s.substring(0,3).equals("056");
        }
    }

}
