package org.example.lesson27.hw;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Добавьте аннотацию Fake с методом String value() default ""
// Повесьте эту аннотацию на поле  specialization класса Course
// В toString в Course используйте value() из аннотации Fake вместо значения specialization если value() не пусто
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Fake {
    String value() default "";
}
