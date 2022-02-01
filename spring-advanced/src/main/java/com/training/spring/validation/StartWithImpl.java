package com.training.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithImpl implements ConstraintValidator<StartWith, String> {

    private StartWith annoWith;

    @Override
    public void initialize(final StartWith annoWith) {
        this.annoWith = annoWith;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.annoWith.value());
    }

}
