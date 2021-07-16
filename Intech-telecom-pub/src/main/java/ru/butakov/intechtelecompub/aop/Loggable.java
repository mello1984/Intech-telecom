package ru.butakov.intechtelecompub.aop;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@Inherited
public @interface Loggable {
}
