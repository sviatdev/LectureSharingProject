package com.springproj.springProject.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//на каком этапе аннотация будет работать
@Target(ElementType.FIELD) //над каким элементом кода мы можем повесить аннотацию
@Constraint(validatedBy = UniqueMovieTitleValidator.class)
public @interface UniqueMovieTitle {
    String message() default "Movie title should be unique";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
