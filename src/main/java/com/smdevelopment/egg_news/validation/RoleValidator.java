package com.smdevelopment.egg_news.validation;

import java.util.Arrays;

import com.smdevelopment.egg_news.enums.Role;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator <ValidRole, Role > { 
    private Role[] subset;

    @Override
    public void initialize(ValidRole constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(Role value, ConstraintValidatorContext context) {
        return Arrays.asList(subset).contains(value);
    }

}
