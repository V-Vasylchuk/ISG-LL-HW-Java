package lessons.fourth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DataValidation {
    String type();
    int minLength() default 0;
    int maxLength() default Integer.MAX_VALUE;
    int minValue() default 0;
    int maxValue() default 130;
}
