package com.sixthou.blogsearchstandalone.common.valid;

import com.sixthou.blogsearchstandalone.common.SortType;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SortTypeValidator implements ConstraintValidator<SortTypeValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return Arrays.stream(SortType.values()).anyMatch(type -> type.name().equals(value));
    }
}
