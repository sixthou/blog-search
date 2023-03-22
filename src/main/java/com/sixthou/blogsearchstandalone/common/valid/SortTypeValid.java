package com.sixthou.blogsearchstandalone.common.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SortTypeValidator.class)
public @interface SortTypeValid {
    String message() default "지원하지 않는 정렬 방식입니다.";
    Class[] groups() default {};
    Class[] payload() default {};
}
